package io.github.swimmingsand.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.BytesRef;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.FileSystems;

import static org.junit.Assert.*;

/**
 * Created by zlq on 2/26/16.
 */
public class IndexerTest {
    protected String[] ids = { "1", "2" };
    protected String[] unindexed = { "NetherLands", "Italy" };
    protected String[] unstored = { "Amsterdam has lots of bridges",
            "Venice has lots of canals" };
    protected String[] text = { "Amsterdam", "Venice" };
    protected float[] areas = { 219, 414.57f };

    private Directory directory;

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    //@Before
    public void setUp() throws Exception {
        directory = new RAMDirectory();
        IndexWriter writer = getWriter();

        for (int i = 0; i < ids.length; i++) {
            Document doc = new Document();
            doc.add(new StringField("id", ids[i], Field.Store.YES));
            doc.add(new StringField("country", unindexed[i], Field.Store.YES));
            doc.add(new TextField("contents", unstored[i], Field.Store.NO));
            doc.add(new TextField("city", text[i], Field.Store.YES));
            doc.add(new FloatPoint("areas", areas[i]));

            writer.addDocument(doc);
            writer.commit();
        }
        writer.close();
        directory.close();
    }

    private IndexWriter getWriter() throws IOException {
        Analyzer analyzer=new StandardAnalyzer();
        IndexWriterConfig indexWriterConfig=new IndexWriterConfig(analyzer );
        System.out.println(indexWriterConfig.getMaxBufferedDeleteTerms());
        System.out.println(indexWriterConfig.getMaxBufferedDocs());
        //System.out.println(indexWriterConfig.getMaxThreadStates());
        System.out.println(indexWriterConfig.getRAMBufferSizeMB());
        System.out.println(indexWriterConfig.getRAMPerThreadHardLimitMB());
        System.out.println(indexWriterConfig.getReaderPooling());
        //System.out.println(indexWriterConfig.getReaderTermsIndexDivisor());
        //System.out.println(indexWriterConfig.getTermIndexInterval());
        System.out.println(indexWriterConfig.getUseCompoundFile());
        //System.out.println(indexWriterConfig.getWriteLockTimeout());

        System.out.println(indexWriterConfig.getCodec().docValuesFormat());
        System.out.println(indexWriterConfig.getCodec().fieldInfosFormat());
        System.out.println(indexWriterConfig.getCodec().termVectorsFormat());
        System.out.println(indexWriterConfig.getCodec().liveDocsFormat());
        System.out.println(indexWriterConfig.getCodec().normsFormat());
        System.out.println(indexWriterConfig.getCodec().postingsFormat());
        System.out.println(indexWriterConfig.getCodec().segmentInfoFormat());
        System.out.println(indexWriterConfig.getCodec().storedFieldsFormat());
        System.out.println(indexWriterConfig.getCodec().termVectorsFormat());
        System.out.println(indexWriterConfig.getCodec().availableCodecs().toString());
        System.out.println(indexWriterConfig.getAnalyzer().toString());
        return new IndexWriter(directory, indexWriterConfig);
    }

    protected int getHitCount(String fieldName, String searchString)
            throws IOException, ParseException {
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(ireader);
        QueryParser parser = new QueryParser(fieldName,
                new StandardAnalyzer());
        Query query = parser.parse(searchString);
        TopDocs topDocs = searcher.search(query, 100);
        ireader.close();
        // directory.close();
        return topDocs.totalHits;

    }

    //@Test
    public void testIndexWriter() throws IOException {
        IndexWriter writer = getWriter();
        assertEquals(ids.length, writer.numDocs());
        writer.close();
    }

    //@Test
    public void testIndexReader() throws IOException {
        DirectoryReader ireader = DirectoryReader.open(directory);
        assertEquals(ids.length, ireader.maxDoc());
        assertEquals(ids.length, ireader.numDocs());
        ireader.close();
    }

    //@Test
    public void testDeleteBeforeOptimize() throws IOException {
        IndexWriter writer = getWriter();
        assertEquals(2, writer.numDocs());

        writer.deleteDocuments(new Term("id", "1"));
        writer.commit();
        assertTrue(writer.hasDeletions());
        assertEquals(2, writer.maxDoc());
        assertEquals(1, writer.numDocs());
        writer.close();
    }

    //@Test
    public void testDeleteAfterOptimize() throws IOException {
        IndexWriter writer = getWriter();
        assertEquals(2, writer.numDocs());

        writer.deleteDocuments(new Term("id", "1"));
        writer.forceMergeDeletes();
        writer.commit();
        assertFalse(writer.hasDeletions());
        assertEquals(1, writer.maxDoc());
        assertEquals(1, writer.numDocs());
        writer.close();
    }

    //@Test
    public void testUpdate() throws IOException, ParseException {
        assertEquals(1, getHitCount("city", "Amsterdam"));

        IndexWriter writer = getWriter();
        Document doc = new Document();
        doc.add(new StringField("id", "1", Field.Store.YES));
        doc.add(new StringField("country", "Netherlands", Field.Store.YES));
        doc.add(new TextField("contents", "Den Haag has a lot of museums",
                Field.Store.NO));
        doc.add(new TextField("city", "Den Hagg", Field.Store.YES));

        writer.updateDocument(new Term("id", "1"), doc);

        writer.close();

        assertEquals(0, getHitCount("city", "Amsterdam"));
        assertEquals(1, getHitCount("city", "Den Hagg"));
    }

    //@Test
    public void testTermQuery() throws IOException {
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(ireader);
        Term term = new Term("id", "1");
        TermQuery termQuery = new TermQuery(term);
        TopDocs topDocs = searcher.search(termQuery, 100);
        assertEquals(1, topDocs.totalHits);

        ireader.close();
    }

    //@Test
    public void testTermRangeQuery() throws IOException {
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(ireader);
        TermRangeQuery termRangeQuery = new TermRangeQuery("city",
                new BytesRef("amsterdam"), new BytesRef("venice"), true, true);
        TopDocs topDocs = searcher.search(termRangeQuery, 100);
        assertEquals(2, topDocs.totalHits);
    }

    //@Test
    public void testNumricRangeQuery() throws IOException {
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(ireader);
        Query query = FloatPoint.newRangeQuery("areas", 200f, 500f);
        TopDocs topDocs = searcher.search(query, 100);
        assertEquals(2, topDocs.totalHits);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    public void test() {
        fail("Not yet implemented");
    }
    @Test
    public void testIndexToDir() throws IOException{
        directory  = FSDirectory.open(FileSystems.getDefault().getPath("/tmp/index"));
        IndexWriter writer = getWriter();

        for (int i = 0; i < ids.length; i++) {
            Document doc = new Document();
            doc.add(new StringField("id", ids[i], Field.Store.YES));
            doc.add(new StringField("country", unindexed[i], Field.Store.YES));
            doc.add(new TextField("contents", unstored[i], Field.Store.NO));
            doc.add(new TextField("city", text[i], Field.Store.YES));
            doc.add(new FloatPoint("areas", areas[i]));

            writer.addDocument(doc);

        }
        writer.commit();
        writer.close();
        directory.close();
    }

}
