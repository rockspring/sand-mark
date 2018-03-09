package io.github.swimmingsand.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.junit.*;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
/**
 * Created by zlq on 2/26/16.
 */
public class MultiPhraseQueryTest {
    private IndexSearcher searcher;

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
        Directory directory=new RAMDirectory();
        Analyzer analyzer=new StandardAnalyzer();
        IndexWriterConfig config=new IndexWriterConfig(analyzer);
        IndexWriter writer=new IndexWriter(directory, config);

        Document doc1=new Document();
        doc1.add(new TextField("field","the quick brwon fox jumped over the lazy dog",Field.Store.YES));
        doc1.add(new TextField("field2","the quick brwon fox jumped over the lazy dog",Field.Store.YES));
        writer.addDocument(doc1);

        Document doc2=new Document();
        doc2.add(new TextField("field","the fast fox hopped over the hound",Field.Store.YES));
        doc2.add(new TextField("field2","the quick brwon fox jumped over the lazy dog",Field.Store.YES));
        writer.addDocument(doc2);
        writer.close();

        //create searcher
        DirectoryReader reader=DirectoryReader.open(directory);
        searcher=new IndexSearcher(reader);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testBasic() throws IOException {
        MultiPhraseQuery.Builder builder = new MultiPhraseQuery.Builder();
        builder.add(new Term[]{new Term("field","quick"),new Term("field","fast")});
        builder.add(new Term("field","fox"));
        builder.setSlop(1);
        MultiPhraseQuery query= builder.build();


        System.out.println(query);

        TopDocs hits=searcher.search(query, 10);
        assertEquals("fast fox match",1,hits.totalHits);

        hits=searcher.search(query, 10);
        assertEquals("both match",2,hits.totalHits);
    }

    @Test
    public void testAgainstOR() throws IOException{
        PhraseQuery.Builder builder = new PhraseQuery.Builder();
        builder.add(new Term("field","quick"));
        builder.add(new Term("field","fox"));
        builder.setSlop(1);
        PhraseQuery quickFox=builder.build();

        PhraseQuery.Builder fastFoxBuilder = new PhraseQuery.Builder();
        fastFoxBuilder.add(new Term("field","fast"));
        fastFoxBuilder.add(new Term("field","fox"));
        PhraseQuery fastFox= fastFoxBuilder.build();


        BooleanQuery.Builder booleanQueryBuilder = new BooleanQuery.Builder();
        booleanQueryBuilder.add(quickFox,Occur.SHOULD);
        booleanQueryBuilder.add(fastFox,Occur.SHOULD);
        BooleanQuery query= booleanQueryBuilder.build();


        TopDocs hits=searcher.search(query, 10);

        assertEquals(2,hits.totalHits);
    }

    @Test
    public void testQueryParser(){
        Analyzer analyzer=new StandardAnalyzer();
        QueryParser query=new QueryParser( "field", analyzer);
    }

    @Test
    public void testDefaultOperator() throws ParseException, IOException{
        Analyzer analyzer=new StandardAnalyzer();
        QueryParser parser=new MultiFieldQueryParser( new String[]{"field","field2"}, analyzer);
        Query query=parser.parse("fox");
        System.out.println(query);
        TopDocs hits=searcher.search(query, 10);

        assertEquals(2,hits.totalHits);

    }

}

