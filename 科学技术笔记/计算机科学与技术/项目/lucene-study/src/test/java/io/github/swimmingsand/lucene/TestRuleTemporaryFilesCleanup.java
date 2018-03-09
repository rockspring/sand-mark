package io.github.swimmingsand.lucene;

import com.carrotsearch.randomizedtesting.RandomizedContext;
import com.carrotsearch.randomizedtesting.rules.TestRuleAdapter;
import org.apache.lucene.mockfile.DisableFsyncFS;
import org.apache.lucene.mockfile.HandleLimitFS;
import org.apache.lucene.mockfile.LeakFS;
import org.apache.lucene.mockfile.WindowsFS;
import org.apache.lucene.util.Constants;
import org.apache.lucene.util.LuceneTestCase;
import org.apache.lucene.util.TestRuleMarkFailure;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * Created by zlq on 3/28/15.
 */
final class TestRuleTemporaryFilesCleanup extends TestRuleAdapter {
    /**
     * Retry to create temporary file name this many times.
     */
    private static final int TEMP_NAME_RETRY_THRESHOLD = 9999;

    /**
     * Writeable temporary base folder.
     */
    private Path javaTempDir;

    /**
     * Per-test class temporary folder.
     */
    private Path tempDirBase;

    /**
     * Per-test filesystem
     */
    private FileSystem fileSystem;

    /**
     * Suite failure marker.
     */
    private final TestRuleMarkFailure failureMarker;

    /**
     * A queue of temporary resources to be removed after the
     * suite completes.
     * @see #registerToRemoveAfterSuite(Path)
     */
    private final static List<Path> cleanupQueue = new ArrayList<Path>();

    public TestRuleTemporaryFilesCleanup(TestRuleMarkFailure failureMarker) {
        this.failureMarker = failureMarker;
    }

    /**
     * Register temporary folder for removal after the suite completes.
     */
    void registerToRemoveAfterSuite(Path f) {
        assert f != null;

        if (LuceneTestCase.LEAVE_TEMPORARY) {
            System.err.println("INFO: Will leave temporary file: " + f.toAbsolutePath());
            return;
        }

        synchronized (cleanupQueue) {
            cleanupQueue.add(f);
        }
    }

    @Override
    protected void before() throws Throwable {
        super.before();

        assert tempDirBase == null;
        fileSystem = initializeFileSystem();
        javaTempDir = initializeJavaTempDir();
    }

    // os/config-independent limit for too many open files
    // TODO: can we make this lower?
    private static final int MAX_OPEN_FILES = 2048;

    private FileSystem initializeFileSystem() {
        FileSystem fs = FileSystems.getDefault();
        Random random = RandomizedContext.current().getRandom();
        // sometimes just use a bare filesystem
        if (random.nextInt(10) > 0) {
            fs = new DisableFsyncFS(fs).getFileSystem(null);
            fs = new LeakFS(fs).getFileSystem(null);
            fs = new HandleLimitFS(fs, MAX_OPEN_FILES).getFileSystem(null);
            // windows is currently slow
            if (random.nextInt(10) == 0) {
                // don't try to emulate windows on windows: they don't get along
                if (!Constants.WINDOWS) {
                    fs = new WindowsFS(fs).getFileSystem(null);
                }
            }
        }
        if (LuceneTestCase.VERBOSE) {
            System.out.println("filesystem: " + fs.provider());
        }
        return fs.provider().getFileSystem(URI.create("file:///"));
    }

    private Path initializeJavaTempDir() throws IOException {
        Path javaTempDir = fileSystem.getPath(System.getProperty("tempDir", System.getProperty("java.io.tmpdir")));

        Files.createDirectories(javaTempDir);

        assert Files.isDirectory(javaTempDir) &&
                Files.isWritable(javaTempDir);

        return javaTempDir.toRealPath();
    }

    @Override
    protected void afterAlways(List<Throwable> errors) throws Throwable {
        // Drain cleanup queue and clear it.
        final Path [] everything;
        final String tempDirBasePath;
        synchronized (cleanupQueue) {
            tempDirBasePath = (tempDirBase != null ? tempDirBase.toAbsolutePath().toString() : null);
            tempDirBase = null;

            Collections.reverse(cleanupQueue);
            everything = new Path [cleanupQueue.size()];
            cleanupQueue.toArray(everything);
            cleanupQueue.clear();
        }

        // Only check and throw an IOException on un-removable files if the test
        // was successful. Otherwise just report the path of temporary files
        // and leave them there.
        if (failureMarker.wasSuccessful()) {
            if (fileSystem != FileSystems.getDefault()) {
                fileSystem.close();
            }
        } else {
            if (tempDirBasePath != null) {
                System.err.println("NOTE: leaving temporary files on disk at: " + tempDirBasePath);
            }
        }
    }

    final Path getPerTestClassTempDir() {
        if (tempDirBase == null) {
            RandomizedContext ctx = RandomizedContext.current();
            Class<?> clazz = ctx.getTargetClass();
            String prefix = clazz.getName();
            prefix = prefix.replaceFirst("^org.apache.lucene.", "lucene.");
            prefix = prefix.replaceFirst("^org.apache.solr.", "solr.");

            int attempt = 0;
            Path f;
            boolean success = false;
            do {
                if (attempt++ >= TEMP_NAME_RETRY_THRESHOLD) {
                    throw new RuntimeException(
                            "Failed to get a temporary name too many times, check your temp directory and consider manually cleaning it: "
                                    + javaTempDir.toAbsolutePath());
                }
                f = javaTempDir.resolve(prefix + " " + ctx.getRunnerSeedAsString()
                        + "-" + String.format(Locale.ENGLISH, "%03d", attempt));
                try {
                    Files.createDirectory(f);
                    success = true;
                } catch (IOException ignore) {}
            } while (!success);

            tempDirBase = f;
            registerToRemoveAfterSuite(tempDirBase);
        }
        return tempDirBase;
    }

    /**
     * @see LuceneTestCase#createTempDir()
     */
    public Path createTempDir(String prefix) {
        Path base = getPerTestClassTempDir();

        int attempt = 0;
        Path f;
        boolean success = false;
        do {
            if (attempt++ >= TEMP_NAME_RETRY_THRESHOLD) {
                throw new RuntimeException(
                        "Failed to get a temporary name too many times, check your temp directory and consider manually cleaning it: "
                                + base.toAbsolutePath());
            }
            f = base.resolve(prefix + "-" + String.format(Locale.ENGLISH, "%03d", attempt));
            try {
                Files.createDirectory(f);
                success = true;
            } catch (IOException ignore) {}
        } while (!success);

        registerToRemoveAfterSuite(f);
        return f;
    }

    /**
     * @see LuceneTestCase#createTempFile()
     */
    public Path createTempFile(String prefix, String suffix) throws IOException {
        Path base = getPerTestClassTempDir();

        int attempt = 0;
        Path f;
        boolean success = false;
        do {
            if (attempt++ >= TEMP_NAME_RETRY_THRESHOLD) {
                throw new RuntimeException(
                        "Failed to get a temporary name too many times, check your temp directory and consider manually cleaning it: "
                                + base.toAbsolutePath());
            }
            f = base.resolve(prefix + "-" + String.format(Locale.ENGLISH, "%03d", attempt) + suffix);
            try {
                Files.createFile(f);
                success = true;
            } catch (IOException ignore) {}
        } while (!success);

        registerToRemoveAfterSuite(f);
        return f;
    }
}
