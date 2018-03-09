package io.github.swimmingsand.lucene.index;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexOptions;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.BytesRef;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * @author zhouleqin
 *
 */
public class Indexer {
    private IndexWriter writer;

    public Indexer(String indexDir) throws IOException {
        Path path = FileSystems.getDefault().getPath(indexDir);
        Directory dir = new SimpleFSDirectory(path);
        writer = new IndexWriter(dir, new IndexWriterConfig(
                new StandardAnalyzer()));
    }

    public void close() throws IOException {
        writer.close();
    }

    public int index(String dataDir, FileFilter filter) throws Exception {
        File[] files = new File(dataDir).listFiles();

        for (File f : files) {
            if (!f.isDirectory() && !f.isHidden() && f.exists() && f.canRead()
                    && (filter == null || filter.accept(f))) {
                indexFile(f);
            }
        }
        return writer.numDocs();
    }

    private static class TextFilesFilter implements FileFilter {
        public boolean accept(File path) {
            return path.getName().toLowerCase().endsWith(".txt");
        }
    }

    protected Document getDocument(File f) throws Exception {
        Document doc = new Document();
        FieldType fieldType = new FieldType();
        fieldType.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
        fieldType.setTokenized(true);
        fieldType.setStored(true);
        fieldType.setStoreTermVectorOffsets(true);
        fieldType.setStoreTermVectorPositions(true);
        fieldType.setStoreTermVectors(true);
        Field field = new Field("contents", "hello, world! hello, world lucene",fieldType);
        doc.add(field);
        doc.add(new StringField("filename", f.getName(), Field.Store.YES));
        doc.add(new StringField("fullpath", f.getCanonicalPath(),
                Field.Store.YES));
        doc.add(new IntField("docLength",100,Field.Store.YES));
        return doc;
    }

    protected Document getDocument2(File f) throws Exception {
        Document doc = new Document();
        FieldType fieldType = new FieldType();
        fieldType.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
        fieldType.setTokenized(true);
        fieldType.setStored(true);
        fieldType.setStoreTermVectorOffsets(true);
        fieldType.setStoreTermVectorPositions(true);
        fieldType.setStoreTermVectors(true);
        Field field = new Field("contents", "hello,lucene",fieldType);
        doc.add(field);
        doc.add(new StringField("filename", f.getName(), Field.Store.YES));
        doc.add(new StringField("fullpath", f.getCanonicalPath(),
                Field.Store.YES));
        doc.add(new IntField("docLength",100,Field.Store.YES));
        return doc;
    }

    private void indexFile(File f) throws Exception {
        System.out.println("Indexing " + f.getCanonicalPath());
        Document doc = getDocument(f);
        writer.addDocument(doc);

        Document doc2 = getDocument2(f);
        writer.addDocument(doc2);
        writer.deleteDocuments(new TermQuery(new Term("docLength", new BytesRef(100))));
        writer.deleteDocuments(new Term("docLength", new BytesRef(100)));
        writer.close();
        System.exit(-1);
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            throw new IllegalArgumentException("Usage: java "
                    + Indexer.class.getName() + " <index dir> <data dir>");
        }
        String indexDir = args[0];
        String dataDir = args[1];

        long start = System.currentTimeMillis();
        Indexer indexer = new Indexer(indexDir);
        int numIndexed;
        try {
            numIndexed = indexer.index(dataDir, new TextFilesFilter());
        } finally {
            indexer.close();
        }

        long end = System.currentTimeMillis();
        System.out.println("Indexing " + numIndexed + " files took "
                + (end - start) + " milliseconds");
    }
}
