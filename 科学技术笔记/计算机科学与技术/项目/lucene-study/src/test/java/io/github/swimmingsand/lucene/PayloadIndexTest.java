package io.github.swimmingsand.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.payloads.FloatEncoder;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.*;
import org.apache.lucene.queries.payloads.MinPayloadFunction;
import org.apache.lucene.queries.payloads.PayloadScoreQuery;
import org.apache.lucene.search.*;
import org.apache.lucene.search.spans.SpanQuery;
import org.apache.lucene.search.spans.SpanTermQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.junit.Test;

import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Created by zlq on 5/20/15.
 */
public class PayloadIndexTest {
    public static String[] DOCS = {

            "The quick|2.0 red|2.0 fox|10.0 jumped|5.0 over the lazy|2.0 brown|2.0 dogs|10.0",

            "The quick red fox jumped over the lazy brown dogs",//no boosts

            "The quick|2.0 red|2.0 fox|10.0 jumped|5.0 over the old|2.0 brown|2.0 box|10.0",

            "Mary|10.0 had a little|2.0 lamb|10.0 whose fleece|10.0 was|5.0 white|2.0 as snow|10.0",

            "Mary had a little lamb whose fleece was white as snow",

            "Mary|10.0 takes on Wolf|10.0 Restoration|10.0 project|10.0 despite ties|10.0 to sheep|10.0 farming|10.0",

            "Mary|10.0 who lives|5.0 on a farm|10.0 is|5.0 happy|2.0 that she|10.0 takes|5.0 a walk|10.0 every day|10.0",

            "Moby|10.0 Dick|10.0 is|5.0 a story|10.0 of a whale|10.0 and a man|10.0 obsessed|10.0",

            "The robber|10.0 wore|5.0 a black|2.0 fleece|10.0 jacket|10.0 and a baseball|10.0 cap|10.0",

            "The English|10.0 Springer|10.0 Spaniel|10.0 is|5.0 the best|2.0 of all dogs|10.0"
    };

    @Test
    public void testIndexLucene50() throws Exception {

        IndexWriter writer;

        URL url = this.getClass().getResource("/");
        //url.getPath();

        Path path = FileSystems.getDefault().getPath(url.getPath()+"/PayloadIndexTest_testIndexLucene50");
        Directory dir = new SimpleFSDirectory(path);


        // Analyzer analyzer = new StandardAnalyzer();
        Analyzer analyzer = new PayloadAnalyzer(new FloatEncoder());
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        config.setUseCompoundFile(false);

        PayloadSimilarity payloadSimilarity = new PayloadSimilarity();
        config.setSimilarity(payloadSimilarity);

        writer = new IndexWriter(dir, config);

        //ImmutableList<String> lines = Files.asCharSource(file, Charsets.UTF_8).readLines();
        for (int i = 0; i < DOCS.length; i++) {

            Document doc = new Document();
            FieldType fieldType = new FieldType();
            fieldType.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
            fieldType.setTokenized(true);
            fieldType.setStored(true);
            fieldType.setStoreTermVectorOffsets(true);
            fieldType.setStoreTermVectorPositions(true);
            fieldType.setStoreTermVectors(true);
            fieldType.setStoreTermVectorPayloads(true);


            //Field id = new StringField("id", "doc " + i, Store.YES);

            //doc.add(id);

            //Store both position and offset information

            Field text = new Field("body", DOCS[i], fieldType);

            doc.add(text);

            writer.addDocument(doc);
        }

        writer.close();

        IndexReader indexReader = DirectoryReader.open(dir);

        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        indexSearcher.setSimilarity(payloadSimilarity);
        TermQuery termQuery = new TermQuery(new Term("body", "quick"));

        TopDocs topDocs = indexSearcher.search(termQuery,10);

        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        for (ScoreDoc scoreDoc : scoreDocs) {
            System.out.println(scoreDoc.doc);
        }

        // acme
        // acne
        RegexpQuery regexpQuery = new RegexpQuery(new Term("body", "ac[a-b]e"));

        topDocs = indexSearcher.search(regexpQuery,10);

        scoreDocs = topDocs.scoreDocs;

        for (ScoreDoc scoreDoc : scoreDocs) {
            System.out.println(scoreDoc.doc);
        }

        //PayloadTermQuery btq = new PayloadTermQuery(new Term("body", "fox"), new AveragePayloadFunction());

        SpanQuery spanQuery = new SpanTermQuery(new Term("body", "fox"));
        PayloadScoreQuery btq = new PayloadScoreQuery(spanQuery, new MinPayloadFunction());
        topDocs = indexSearcher.search(btq, 10);

        for (int i = 0; i < topDocs.scoreDocs.length; i++) {

            ScoreDoc doc = topDocs.scoreDocs[i];

            System.out.println("Doc: " + doc.toString());

            System.out.println("Explain: " + indexSearcher.explain(btq, doc.doc));

        }
    }
}
