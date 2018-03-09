package io.github.swimmingsand.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.spans.SpanQuery;
import org.apache.lucene.search.spans.SpanTermQuery;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Bits;
import org.junit.*;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by zlq on 2/26/16.
 */
public class SpanQueryTest {
    private Analyzer analyzer = new StandardAnalyzer();

    private IndexSearcher indexSearcher;
    private IndexReader indexReader;

    private SpanTermQuery quick;
    private SpanTermQuery brown;
    private SpanTermQuery red;
    private SpanTermQuery fox;
    private SpanTermQuery lazy;
    private SpanTermQuery sleepy;
    private SpanTermQuery dog;
    private SpanTermQuery cat;

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
    @Before
    public void setUp() throws Exception {
        RAMDirectory directory=new RAMDirectory();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter=new IndexWriter(directory, indexWriterConfig);

        Document doc=new Document();
        doc.add(new TextField("f", "the quick brown fox jumps over the lazy dob", Field.Store.YES));
        indexWriter.addDocument(doc);

        doc=new Document();
        doc.add(new TextField("f","the quick red fox jumps over the sleepy cat",Field.Store.YES));
        indexWriter.addDocument(doc);

        indexWriter.close();

        indexReader=DirectoryReader.open(directory);
        indexSearcher=new IndexSearcher(indexReader);

        quick=new SpanTermQuery(new Term("f", "quick"));
        brown=new SpanTermQuery(new Term("f", "brown"));
        red=new SpanTermQuery(new Term("f", "red"));
        fox=new SpanTermQuery(new Term("f", "fox"));
        lazy=new SpanTermQuery(new Term("f", "lazy"));
        sleepy=new SpanTermQuery(new Term("f", "sleepy"));
        dog=new SpanTermQuery(new Term("f", "dog"));
        cat=new SpanTermQuery(new Term("f", "cat"));
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        try {
            TopDocs topDocs=indexSearcher.search(brown, 10);
            assertEquals(1, topDocs.totalHits);
            assertEquals("wrong doc",0,topDocs.scoreDocs[0].doc);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void dumpSpans(SpanQuery query) throws IOException{
        Bits acceptDocs;
        Map<Term, TermContext> termContexts;
    }

}
