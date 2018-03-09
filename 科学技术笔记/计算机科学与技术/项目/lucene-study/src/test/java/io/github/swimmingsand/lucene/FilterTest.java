package io.github.swimmingsand.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.BytesRef;
import org.apache.solr.search.QueryWrapperFilter;
import org.junit.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zlq on 2/26/16.
 */
public class FilterTest {
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
    @Before
    public void setUp() throws Exception {
        directory = new RAMDirectory();
        Analyzer analyzer=new StandardAnalyzer();
        IndexWriterConfig indexWriterConfig=new IndexWriterConfig(analyzer );
        IndexWriter indexWriter= new IndexWriter(directory, indexWriterConfig);
        Document doc=new Document();
        FieldType bodyType = new FieldType(TextField.TYPE_STORED);
        bodyType.setStoreTermVectors(true);
        doc.add(new Field("title", "The Well-Grounded Java Developer", bodyType));
        //doc.add(new TextField("title", "The Well-Grounded Java Developer", Field.Store.YES));
        doc.add(new StringField("pubyear", "2013", Field.Store.YES));
        doc.add(new IntPoint("pages",395));
        indexWriter.addDocument(doc);

        doc=new Document();
        doc.add(new TextField("title", "Thinking In Java", Field.Store.YES));
        doc.add(new StringField("pubyear", "2010", Field.Store.YES));
        doc.add(new IntPoint("pages",1008));
        indexWriter.addDocument(doc);

        doc=new Document();
        doc.add(new TextField("title", "The Future of Computing", Field.Store.YES));
        doc.add(new StringField("pubyear", "2013", Field.Store.YES));
        doc.add(new IntPoint("pages",355));
        indexWriter.addDocument(doc);

        indexWriter.close();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testTermFilter() throws IOException {
        System.out.println("testTermFilter start");
        DirectoryReader indexReader=DirectoryReader.open(directory);
        IndexSearcher indexSearcher=new IndexSearcher(indexReader);
        Query query=new TermQuery(new Term("pubyear","2013"));
        TopDocs hits=indexSearcher.search(query, 10);
        System.out.println(hits.totalHits);

        TermQuery termQuery = new TermQuery(new Term("title","thinking"));
        QueryWrapperFilter filter=new QueryWrapperFilter(termQuery);
        hits=indexSearcher.search(query,10);
        System.out.println(query.toString()+" "+filter.toString()+hits.totalHits);
        System.out.println("testTermFilter finish");
    }

    @Test
    public void testTermRangeFilter() throws IOException{
        System.out.println("testTermRangeFilter start");
        DirectoryReader indexReader=DirectoryReader.open(directory);
        IndexSearcher indexSearcher=new IndexSearcher(indexReader);
        Query query= new MatchAllDocsQuery();
        TopDocs hits=indexSearcher.search(query, 10);
        System.out.println(query.toString()+hits.totalHits);

        TermRangeQuery filter=new TermRangeQuery("pubyear", new BytesRef("2010"),  new BytesRef("2013"), true, true);
        hits=indexSearcher.search(query,10);
        System.out.println(query.toString()+" "+filter.toString()+hits.totalHits);
        System.out.println("testTermRangeFilter finish");
    }

    @Test
    public void testNumericRangeFilter() throws IOException{
        System.out.println("testNumericRangeFilter start");
        DirectoryReader indexReader=DirectoryReader.open(directory);
        IndexSearcher indexSearcher=new IndexSearcher(indexReader);
        Query query= new MatchAllDocsQuery();
        TopDocs hits=indexSearcher.search(query, 10);
        System.out.println(query.toString()+hits.totalHits);

        Query query1 = IntPoint.newRangeQuery("pages", 100, 500);
        hits=indexSearcher.search(query1,10);
        System.out.println(query.toString()+" "+query1.toString()+hits.totalHits);
        System.out.println("testNumericRangeFilter finish");
    }

    @Test
    public void testFieldCacheRangeFilter() throws IOException{
        System.out.println("testFieldCacheRangeFilter start");
        DirectoryReader indexReader=DirectoryReader.open(directory);
        IndexSearcher indexSearcher=new IndexSearcher(indexReader);
        Query query= new MatchAllDocsQuery();
        TopDocs hits=indexSearcher.search(query, 10);
        System.out.println(query.toString()+hits.totalHits);

        /*Filter filter=FieldCacheRangeFilter.newIntRange("pages", 100, 500, true, true);
        hits=indexSearcher.search(query, filter,10);
        System.out.println(query.toString()+" "+filter.toString()+hits.totalHits);
        System.out.println("testFieldCacheRangeFilter finish");*/
    }

    @Test
    public void testFieldCacheTermsFilter() throws IOException{
        System.out.println("testFieldCacheTermsFilter start");
        DirectoryReader indexReader=DirectoryReader.open(directory);
        IndexSearcher indexSearcher=new IndexSearcher(indexReader);
        Query query= new MatchAllDocsQuery();
        TopDocs hits=indexSearcher.search(query, 10);
        System.out.println(query.toString()+hits.totalHits);

        /*Filter filter=new FieldCacheTermsFilter("title", new String[]{"thinking","computing"});
        hits=indexSearcher.search(query, filter,10);
        System.out.println(query.toString()+" "+filter.toString()+hits.totalHits);
        System.out.println("testFieldCacheTermsFilter finish");*/
    }

    @Test
    public void test() throws IOException{
        DirectoryReader indexReader=DirectoryReader.open(directory);
        Terms terms=indexReader.getTermVector(0, "title");
        TermsEnum reuse = null;
        terms.iterator();
        Map<String, Integer> frequencies = new HashMap<String, Integer>();
        BytesRef text = null;
        while ((text = reuse.next()) != null) {
            String term = text.utf8ToString();
            int freq = (int) reuse.totalTermFreq();
            frequencies.put(term, freq);
            //terms.add(term);
        }
    }
}
