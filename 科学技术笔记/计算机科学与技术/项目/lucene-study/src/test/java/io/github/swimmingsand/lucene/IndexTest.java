package io.github.swimmingsand.lucene;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.io.CharSource;
import com.google.common.io.Resources;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.payloads.TypeAsPayloadTokenFilter;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.codecs.Codec;
import org.apache.lucene.codecs.DocValuesFormat;
import org.apache.lucene.codecs.PostingsFormat;
import org.apache.lucene.document.*;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.junit.Test;

import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Set;

/**
 * Created by zlq on 4/3/15.
 */
public class IndexTest {

    @Test
    public void testIndex() throws Exception {
        IndexWriter writer;

        Path path = FileSystems.getDefault().getPath("/tmp/a");
        Directory dir = new SimpleFSDirectory(path);
        writer = new IndexWriter(dir, new IndexWriterConfig(
                new StandardAnalyzer()));

        Document doc = new Document();
        FieldType fieldType = new FieldType();
        fieldType.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
        fieldType.setTokenized(true);
        fieldType.setStored(true);
        fieldType.setStoreTermVectorOffsets(true);
        fieldType.setStoreTermVectorPositions(true);
        fieldType.setStoreTermVectors(true);
        Field field = new Field("contents", "hello, world! hello, world lucene", fieldType);
        doc.add(field);
        doc.add(new IntPoint("docLength", 100));

        writer.addDocument(doc);
        writer.close();
    }

    @Test
    public void testIndex2() throws Exception {
        IndexWriter writer;

        Path path = FileSystems.getDefault().getPath("/tmp/a");
        Directory dir = new SimpleFSDirectory(path);


        // Analyzer analyzer = new StandardAnalyzer();
        Analyzer analyzer = new Analyzer() {
            @Override
            protected TokenStreamComponents createComponents(String fieldName) {
                Tokenizer source = new StandardTokenizer();
                TokenStream filter = new TypeAsPayloadTokenFilter(source);
                return new TokenStreamComponents(source, filter);
            }
        };
        IndexWriterConfig config = new IndexWriterConfig(
                analyzer);
        config.setUseCompoundFile(false);
        //config.setCodec(Codec.forName("SimpleText"));
        writer = new IndexWriter(dir, config);

        Set<String> availableCodecs = Codec.availableCodecs();
        Set<String> availablePostingsFormats = PostingsFormat.availablePostingsFormats();
        Set<String> availableDocValuesFormats = DocValuesFormat.availableDocValuesFormats();

        Document doc = new Document();
        FieldType fieldType = new FieldType();
        fieldType.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
        fieldType.setTokenized(true);
        fieldType.setStored(true);
        fieldType.setStoreTermVectorOffsets(true);
        fieldType.setStoreTermVectorPositions(true);
        fieldType.setStoreTermVectors(true);
        fieldType.setStoreTermVectorPayloads(true);

        Field field = new Field("contents", "Hello,Lucene!", fieldType);


        doc.add(field);

        writer.addDocument(doc);
        writer.close();
    }

    @Test
    public void testIndex3() throws Exception {
        IndexWriter writer;

        Path path = FileSystems.getDefault().getPath("/tmp/a");
        Directory dir = new SimpleFSDirectory(path);


        // Analyzer analyzer = new StandardAnalyzer();
        Analyzer analyzer = new Analyzer() {
            @Override
            protected TokenStreamComponents createComponents(String fieldName) {
                Tokenizer source = new StandardTokenizer();
                TokenStream filter = new TypeAsPayloadTokenFilter(source);
                return new TokenStreamComponents(source, filter);
            }
        };
        IndexWriterConfig config = new IndexWriterConfig(
                analyzer);
        config.setUseCompoundFile(false);
        writer = new IndexWriter(dir, config);


        Document doc = new Document();
        FieldType fieldType = new FieldType();
        fieldType.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
        fieldType.setTokenized(true);
        fieldType.setStored(true);
        fieldType.setStoreTermVectorOffsets(true);
        fieldType.setStoreTermVectorPositions(true);
        fieldType.setStoreTermVectors(true);
        fieldType.setStoreTermVectorPayloads(true);

        Field field = new Field("contents", "Hello,Lucene!", fieldType);


        doc.add(field);
        doc.add(new SortedNumericDocValuesField("length", 13));

        writer.addDocument(doc);
        writer.close();
    }

    @Test
    public void testIndexSimpleText() throws Exception {
        IndexWriter writer;

        Path path = FileSystems.getDefault().getPath("/tmp/a");
        Directory dir = new SimpleFSDirectory(path);


        // Analyzer analyzer = new StandardAnalyzer();
        Analyzer analyzer = new Analyzer() {
            @Override
            protected TokenStreamComponents createComponents(String fieldName) {
                Tokenizer source = new StandardTokenizer();
                TokenStream filter = new TypeAsPayloadTokenFilter(source);
                return new TokenStreamComponents(source, filter);
            }
        };
        IndexWriterConfig config = new IndexWriterConfig(
                analyzer);
        config.setUseCompoundFile(false);
        config.setCodec(Codec.forName("SimpleText"));
        writer = new IndexWriter(dir, config);

        Set<String> availableCodecs = Codec.availableCodecs();
        Set<String> availablePostingsFormats = PostingsFormat.availablePostingsFormats();
        Set<String> availableDocValuesFormats = DocValuesFormat.availableDocValuesFormats();

        Document doc = new Document();
        FieldType fieldType = new FieldType();
        fieldType.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
        fieldType.setTokenized(true);
        fieldType.setStored(true);
        fieldType.setStoreTermVectorOffsets(true);
        fieldType.setStoreTermVectorPositions(true);
        fieldType.setStoreTermVectors(true);
        fieldType.setStoreTermVectorPayloads(true);

        Field field = new Field("contents", "Hello,Lucene!", fieldType);
        Field field1 = new TextField("内容", "搜索引擎，你好", Store.YES);

        doc.add(field);
        doc.add(field1);

        writer.addDocument(doc);

        field = new Field("contents", "Hello,World!", fieldType);
        field1 = new TextField("内容", "世界，你好", Store.YES);

        doc = new Document();
        doc.add(field);
        doc.add(field1);

        writer.addDocument(doc);
        writer.close();
    }

    @Test
    public void testIndexLucene50() throws Exception {
        IndexWriter writer;

        URL url = this.getClass().getResource("/");
        //url.getPath();

        Path path = FileSystems.getDefault().getPath(url.getPath()+"/testIndexLucene50");
        Directory dir = new SimpleFSDirectory(path);


        // Analyzer analyzer = new StandardAnalyzer();
        Analyzer analyzer = new Analyzer() {
            @Override
            protected TokenStreamComponents createComponents(String fieldName) {
                Tokenizer source = new StandardTokenizer();
                TokenStream filter = new TypeAsPayloadTokenFilter(source);
                return new TokenStreamComponents(source, filter);
            }
        };
        IndexWriterConfig config = new IndexWriterConfig(
                analyzer);
        config.setUseCompoundFile(false);
        writer = new IndexWriter(dir, config);


        Document doc = new Document();
        FieldType fieldType = new FieldType();
        fieldType.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
        fieldType.setTokenized(true);
        fieldType.setStored(true);
        fieldType.setStoreTermVectorOffsets(true);
        fieldType.setStoreTermVectorPositions(true);
        fieldType.setStoreTermVectors(true);
        fieldType.setStoreTermVectorPayloads(true);

        //ImmutableList<String> lines = Files.asCharSource(file, Charsets.UTF_8).readLines();
        URL dictFileUrl = this.getClass().getResource("/gre.dict.txt");
         CharSource charSource = Resources.asCharSource(dictFileUrl, Charsets.UTF_8);
        ImmutableList<String> lines = charSource.readLines();

        for (String line: lines) {
            System.out.println(line);
            Field field = new Field("word",line, fieldType);

            //doc = new Document();//
            doc.add(field);
            writer.addDocument(doc);
        }

        writer.close();

        IndexReader indexReader = DirectoryReader.open(dir);

        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        TermQuery termQuery = new TermQuery(new Term("word", "adage"));

        TopDocs topDocs = indexSearcher.search(termQuery,10);

        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        for (ScoreDoc scoreDoc : scoreDocs) {
            System.out.println(scoreDoc.doc);
        }

        // acme
        // acne
        RegexpQuery regexpQuery = new RegexpQuery(new Term("word", "ac[a-b]e"));

        topDocs = indexSearcher.search(regexpQuery,10);

        scoreDocs = topDocs.scoreDocs;

        for (ScoreDoc scoreDoc : scoreDocs) {
            System.out.println(scoreDoc.doc);
        }

    }

    @Test
    public void testIndexLucene50_2() throws Exception {
        IndexWriter writer;

        URL url = this.getClass().getResource("/");
        //url.getPath();

        Path path = FileSystems.getDefault().getPath(url.getPath()+"/testIndexLucene50");
        Directory dir = new SimpleFSDirectory(path);


        // Analyzer analyzer = new StandardAnalyzer();
        Analyzer analyzer = new Analyzer() {
            @Override
            protected TokenStreamComponents createComponents(String fieldName) {
                Tokenizer source = new WhitespaceTokenizer();
                TokenStream filter = new TypeAsPayloadTokenFilter(source);
                return new TokenStreamComponents(source, filter);
            }
        };
        IndexWriterConfig config = new IndexWriterConfig(
                analyzer);
        config.setUseCompoundFile(false);
        writer = new IndexWriter(dir, config);




        //ImmutableList<String> lines = Files.asCharSource(file, Charsets.UTF_8).readLines();
        URL dictFileUrl = this.getClass().getResource("/gre.dict.full.work.txt");
        CharSource charSource = Resources.asCharSource(dictFileUrl, Charsets.UTF_8);
        ImmutableList<String> lines = charSource.readLines();

        StringBuilder text = new StringBuilder();

        for (String line: lines) {
            //System.out.println(line);
            text.append(line);
            text.append(" ");
            System.out.println(text.toString());

            Document doc = new Document();
            FieldType fieldType = new FieldType();
            fieldType.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
            fieldType.setTokenized(true);
            fieldType.setStored(true);
            fieldType.setStoreTermVectorOffsets(true);
            fieldType.setStoreTermVectorPositions(true);
            fieldType.setStoreTermVectors(true);
            fieldType.setStoreTermVectorPayloads(true);

            Field field = new Field("word",text.toString(), fieldType);
            doc.add(field);

            writer.addDocument(doc);
        }

        writer.close();

        IndexReader indexReader = DirectoryReader.open(dir);

        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        TermQuery termQuery = new TermQuery(new Term("word", "adage"));

        TopDocs topDocs = indexSearcher.search(termQuery,10000);
        indexSearcher.doc(1000);

        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        int count = 0;
        for (ScoreDoc scoreDoc : scoreDocs) {

            count++;
            if (count >10) {
                break;
            }

            System.out.println("Doc: " + scoreDoc);

            System.out.println("Explain: " + indexSearcher.explain(termQuery, scoreDoc.doc));
        }

        // acme
        // acne
        /*RegexpQuery regexpQuery = new RegexpQuery(new Term("word", "ac[a-b]e"));

        topDocs = indexSearcher.search(regexpQuery,10);

        scoreDocs = topDocs.scoreDocs;

        for (ScoreDoc scoreDoc : scoreDocs) {
            System.out.println(scoreDoc.doc);
        }*/

    }

    @Test
    public void testIndexLucene50_3() throws Exception {
        IndexWriter writer;

        URL url = this.getClass().getResource("/");
        //url.getPath();

        Path path = FileSystems.getDefault().getPath(url.getPath()+"/testIndexLucene50");
        Directory dir = new SimpleFSDirectory(path);


        // Analyzer analyzer = new StandardAnalyzer();
        Analyzer analyzer = new Analyzer() {
            @Override
            protected TokenStreamComponents createComponents(String fieldName) {
                Tokenizer source = new WhitespaceTokenizer();
                TokenStream filter = new TypeAsPayloadTokenFilter(source);
                return new TokenStreamComponents(source, filter);
            }
        };
        IndexWriterConfig config = new IndexWriterConfig(
                analyzer);
        config.setUseCompoundFile(false);
        writer = new IndexWriter(dir, config);




        //ImmutableList<String> lines = Files.asCharSource(file, Charsets.UTF_8).readLines();
        URL dictFileUrl = this.getClass().getResource("/gre.dict.full.work.txt");
        CharSource charSource = Resources.asCharSource(dictFileUrl, Charsets.UTF_8);
        ImmutableList<String> lines = charSource.readLines();


        Document doc = new Document();
        IntPoint field = new IntPoint("price", 300);

        doc.add(field);

        writer.addDocument(doc);

        doc = new Document();
        field = new IntPoint("price", 400);

        doc.add(field);

        writer.addDocument(doc);

        writer.close();

        IndexReader indexReader = DirectoryReader.open(dir);

        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        TermQuery termQuery = new TermQuery(new Term("word", "adage"));

        TopDocs topDocs = indexSearcher.search(termQuery,10000);
        //indexSearcher.doc(1);

        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        int count = 0;
        for (ScoreDoc scoreDoc : scoreDocs) {

            count++;
            if (count >10) {
                break;
            }

            System.out.println("Doc: " + scoreDoc);

            System.out.println("Explain: " + indexSearcher.explain(termQuery, scoreDoc.doc));
        }

        // 0b1 00000001  0b1 100000011
        Query query = IntPoint.newRangeQuery("price", 257, 771);

        topDocs = indexSearcher.search(query, 10000);

        scoreDocs = topDocs.scoreDocs;

        count = 0;
        for (ScoreDoc scoreDoc : scoreDocs) {

            count++;
            if (count >10) {
                break;
            }

            System.out.println("Doc: " + scoreDoc);

            System.out.println("Explain: " + indexSearcher.explain(termQuery, scoreDoc.doc));
        }

        // acme
        // acne
        /*RegexpQuery regexpQuery = new RegexpQuery(new Term("word", "ac[a-b]e"));

        topDocs = indexSearcher.search(regexpQuery,10);

        scoreDocs = topDocs.scoreDocs;

        for (ScoreDoc scoreDoc : scoreDocs) {
            System.out.println(scoreDoc.doc);
        }*/

    }
}
