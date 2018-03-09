package io.github.swimmingsand.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.junit.*;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Created by zlq on 2/26/16.
 */
public class SortingSearchTest {
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
        doc.add(new TextField("title", "The Well-Grounded Java Developer", Field.Store.YES));
        doc.add(new StringField("pubyear", "2013", Field.Store.YES));
        indexWriter.addDocument(doc);

        doc=new Document();
        doc.add(new TextField("title", "Thinking In Java", Field.Store.YES));
        doc.add(new StringField("pubyear", "2013", Field.Store.YES));
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
    public void test() {
        Query allBooks=new MatchAllDocsQuery();
        Analyzer analyzer=new StandardAnalyzer();
        QueryParser parser=new QueryParser( "title", analyzer);

        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        try {
            builder.add(parser.parse("Java OR action"),BooleanClause.Occur.SHOULD);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BooleanQuery query=builder.build();
        DirectoryReader indexReader = null;
        try {
            indexReader = DirectoryReader.open(directory);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        IndexSearcher indexSearcher=new IndexSearcher(indexReader);
        TopDocs results=null;
        Sort sort=Sort.RELEVANCE;
        try {
            results=indexSearcher.search(query, 10,sort,true,true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Result for:"+query.toString()+" sorted by "+sort);

        DecimalFormat scoreFormatter=new DecimalFormat("0.######");

        for(ScoreDoc scoreDoc:results.scoreDocs){
            int docID=scoreDoc.doc;
            float score=scoreDoc.score;
            Document doc=null;
            try {
                doc=indexSearcher.doc(docID);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            /*System.out.println(StringUtils.rightPad(doc.get("title"), 50)+
                    StringUtils.rightPad(doc.get("pubyear"), 6)+
                    StringUtils.center(""+docID, 4)+
                    StringUtils.leftPad(scoreFormatter.format(score), 12));*/
        }

        try {
            indexReader.close();
            directory.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testSortingSearch(){
        Sort sort=new Sort(new SortField("title",SortField.Type.STRING));
        SortedResult(sort);
        System.out.println(".....................................");
        sort=new Sort(new SortField("pubyear",SortField.Type.STRING));
        SortedResult(sort);
        System.out.println(".....................................");
        sort=new Sort(new SortField("pubyear",SortField.Type.STRING,true));
        SortedResult(sort);
        System.out.println(".....................................");
        sort=new Sort(new SortField("pubyear",SortField.Type.STRING),new SortField("title",SortField.Type.STRING,true));
        SortedResult(sort);
        System.out.println(".....................................");
        sort=Sort.INDEXORDER;
        SortedResult(sort);
        System.out.println(".....................................");
        sort=Sort.RELEVANCE;
        SortedResult(sort);
    }

    private void SortedResult(Sort sort){
        Query allBooks=new MatchAllDocsQuery();
        Analyzer analyzer=new StandardAnalyzer();
        QueryParser parser=new QueryParser( "title", analyzer);

        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        try {
            builder.add(parser.parse("Java OR action"),BooleanClause.Occur.SHOULD);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BooleanQuery query = builder.build();
        DirectoryReader indexReader = null;
        try {
            indexReader = DirectoryReader.open(directory);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        IndexSearcher indexSearcher=new IndexSearcher(indexReader);
        TopDocs results=null;
        try {
            results=indexSearcher.search(query, 10,sort,true,true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Result for:"+query.toString()+" sorted by "+sort);

        DecimalFormat scoreFormatter=new DecimalFormat("0.######");

        for(ScoreDoc scoreDoc:results.scoreDocs){
            int docID=scoreDoc.doc;
            float score=scoreDoc.score;

            Document doc=null;
            try {
                doc=indexSearcher.doc(docID);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            /*System.out.println(StringUtils.rightPad(doc.get("title"), 50)+
                    StringUtils.rightPad(doc.get("pubyear"), 6)+
                    StringUtils.center(""+docID, 4)+
                    StringUtils.rightPad(scoreFormatter.format(score), 12)+
                    StringUtils.leftPad(scoreDoc.toString(),10));*/
        }

        try {
            System.out.println(indexSearcher.explain(query, 0));
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            indexReader.close();
            //directory.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

