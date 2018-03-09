package io.github.swimmingsand.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.payloads.TypeAsPayloadTokenFilter;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.codecs.Codec;
import org.apache.lucene.codecs.DocValuesFormat;
import org.apache.lucene.codecs.PostingsFormat;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexOptions;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.junit.Test;

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
        doc.add(new IntField("docLength", 100, Field.Store.YES));

        writer.addDocument(doc);
        writer.close();
    }

    @Test
    public void testIndex2() throws Exception {
        IndexWriter writer;

        Path path = FileSystems.getDefault().getPath("/tmp/simple_text");
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
    public void testIndexLucene50() throws Exception {
        IndexWriter writer;

        Path path = FileSystems.getDefault().getPath("/tmp/lucene50");
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
        config.setCodec(Codec.forName("Lucene50"));
        config.setMaxBufferedDocs(2);//maxBufferedDocs must at least be 2 when enabled
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
    public void testIndexSimpleText() throws Exception {
        IndexWriter writer;

        Path path = FileSystems.getDefault().getPath("/tmp/simple_text");
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
}
