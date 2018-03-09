package io.github.swimmingsand.lucene.index;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queries.function.FunctionQuery;
import org.apache.lucene.queries.function.valuesource.ConstValueSource;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.search.vectorhighlight.FastVectorHighlighter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.BytesRefBuilder;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * @author zhouleqin
 *
 */
public class Searcher {

    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws IllegalArgumentException,
            IOException, ParseException {
        if (args.length != 0) {
            throw new IllegalArgumentException("Usage: java "
                    + Searcher.class.getName() + " <index dir> <query>");
        }

        //String indexDir = args[0];
        //String q = args[1];
        String indexDir = "index";
        String q = "Indexer";
        search(indexDir, q);
    }

    public static void search(String indexDir, String q) throws IOException,
            ParseException {
        Path path = FileSystems.getDefault().getPath(indexDir);
        Directory dir = new SimpleFSDirectory(path);
        //Directory dir = FSDirectory.open(new File(indexDir));
        DirectoryReader ireader = DirectoryReader.open(dir);
        IndexSearcher is = new IndexSearcher(ireader);
        QueryParser parser = new QueryParser("contents", new StandardAnalyzer());
        Query query = parser.parse(q);
        //BooleanQuery booleanQuery = new BooleanQuery();
        //booleanQuery.add(new TermQuery(new Term("contents","hello")), BooleanClause.Occur.MUST);
        //booleanQuery.add(new TermQuery(new Term("filename","Indexer.txt")),BooleanClause.Occur.MUST);
        TermQuery termQuery = new TermQuery(new Term("contents", "hello"));
        Query numericRangeQuery = IntPoint.newRangeQuery("docLength", 100, 100);

        TermQuery query1 = new TermQuery(new Term("docLength", "100"));

        PhraseQuery phraseQuery = new PhraseQuery(2, "contents", "hello", "world");

        BytesRefBuilder bytesRefBuilder = new BytesRefBuilder();
        query1 = new TermQuery(new Term("docLength", bytesRefBuilder.toBytesRef()));
        long start = System.currentTimeMillis();

        FunctionQuery functionQuery = new FunctionQuery(new ConstValueSource(100));

        TopDocs hits = is.search(functionQuery, 10);

        long end = System.currentTimeMillis();

        System.err.println("Found " + hits.totalHits + " document(s) (in "
                + (end - start) + " milliseconds) that matched query '" + q
                + "':");

        for (ScoreDoc scoreDoc : hits.scoreDocs) {
            Document doc = is.doc(scoreDoc.doc);
            System.out.printf("%s, %s\n", doc.get("fullpath"), scoreDoc.score);
        }


        SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter();
        Highlighter highlighter = new Highlighter(htmlFormatter, new QueryScorer(termQuery));
        for (int i = 0; i < 1; i++) {
            int id = hits.scoreDocs[i].doc;
            Document doc = is.doc(id);
            String text = doc.get("contents");
            TokenStream tokenStream = TokenSources.getAnyTokenStream(is.getIndexReader(), id, "contents", new StandardAnalyzer());
            TextFragment[] frag = null;
            try {
                frag = highlighter.getBestTextFragments(tokenStream, text, false, 10);//highlighter.getBestFragments(tokenStream, text, 3, "...");
            } catch (InvalidTokenOffsetsException e) {

            }
            for (int j = 0; j < frag.length; j++) {
                if ((frag[j] != null) && (frag[j].getScore() > 0)) {
                    System.out.println((frag[j].toString()));
                }
            }
            //Term vector
            text = doc.get("contents");
            String[] frags = null;
            tokenStream = TokenSources.getAnyTokenStream(is.getIndexReader(), hits.scoreDocs[i].doc, "contents", new StandardAnalyzer());
            try {
                FastVectorHighlighter highlighter1 = new FastVectorHighlighter();
                //frag = highlighter1.getBestFragment(highlighter1.getFieldQuery(query),is.getIndexReader(),id,"contents",1);
                frags = highlighter1.getBestFragments(highlighter1.getFieldQuery(termQuery),is.getIndexReader(),id,"contents",18,18);

            } catch (IOException e) {

            }
            System.out.println("FastVectorHighlighter");
            for (int k = 0; k<frags.length; k++) {
                System.out.println(frags[i]);
            }
            System.out.println("FastVectorHighlighter");
            for (int j = 0; j < frag.length; j++) {
                if ((frag[j] != null) && (frag[j].getScore() > 0)) {
                    System.out.println((frag[j].toString()));
                }
            }
            System.out.println("-------------");

            ireader.close();
            dir.close();
        }
    }
}
