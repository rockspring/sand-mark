# backward-codecs
.
└── META-INF
    └── services
        ├── org.apache.lucene.codecs.Codec
        ├── org.apache.lucene.codecs.DocValuesFormat
        └── org.apache.lucene.codecs.PostingsFormat

## org.apache.lucene.codecs.Codec

```
org.apache.lucene.codecs.lucene40.Lucene40Codec
org.apache.lucene.codecs.lucene41.Lucene41Codec
org.apache.lucene.codecs.lucene42.Lucene42Codec
org.apache.lucene.codecs.lucene45.Lucene45Codec
org.apache.lucene.codecs.lucene46.Lucene46Codec
org.apache.lucene.codecs.lucene49.Lucene49Codec
org.apache.lucene.codecs.lucene410.Lucene410Codec
```

## org.apache.lucene.codecs.DocValuesFormat

```
org.apache.lucene.codecs.lucene42.Lucene42DocValuesFormat
org.apache.lucene.codecs.lucene45.Lucene45DocValuesFormat
org.apache.lucene.codecs.lucene49.Lucene49DocValuesFormat
org.apache.lucene.codecs.lucene410.Lucene410DocValuesFormat
```

## org.apache.lucene.codecs.PostingsFormat

```
org.apache.lucene.codecs.lucene40.Lucene40PostingsFormat
org.apache.lucene.codecs.lucene41.Lucene41PostingsFormat
```

# codecs
.
└── META-INF
    └── services
        ├── org.apache.lucene.codecs.Codec
        ├── org.apache.lucene.codecs.DocValuesFormat
        └── org.apache.lucene.codecs.PostingsFormat

## org.apache.lucene.codecs.Codec

```
org.apache.lucene.codecs.simpletext.SimpleTextCodec
```

## org.apache.lucene.codecs.DocValuesFormat

```
org.apache.lucene.codecs.memory.MemoryDocValuesFormat
org.apache.lucene.codecs.memory.DirectDocValuesFormat
org.apache.lucene.codecs.simpletext.SimpleTextDocValuesFormat
```

## org.apache.lucene.codecs.PostingsFormat

```
org.apache.lucene.codecs.blocktreeords.BlockTreeOrdsPostingsFormat
org.apache.lucene.codecs.bloom.BloomFilteringPostingsFormat
org.apache.lucene.codecs.memory.DirectPostingsFormat
org.apache.lucene.codecs.memory.FSTOrdPostingsFormat
org.apache.lucene.codecs.memory.FSTPostingsFormat
org.apache.lucene.codecs.memory.MemoryPostingsFormat
org.apache.lucene.codecs.simpletext.SimpleTextPostingsFormat
```

# core
.
└── META-INF
    └── services
        ├── org.apache.lucene.codecs.Codec
        ├── org.apache.lucene.codecs.DocValuesFormat
        └── org.apache.lucene.codecs.PostingsFormat

## org.apache.lucene.codecs.Codec

```
org.apache.lucene.codecs.lucene50.Lucene50Codec
```

## org.apache.lucene.codecs.DocValuesFormat

```
org.apache.lucene.codecs.lucene50.Lucene50DocValuesFormat
```

## org.apache.lucene.codecs.PostingsFormat

```
org.apache.lucene.codecs.lucene50.Lucene50PostingsFormat
```

# test-framework
.
└── META-INF
    └── services
        ├── org.apache.lucene.codecs.Codec
        ├── org.apache.lucene.codecs.DocValuesFormat
        └── org.apache.lucene.codecs.PostingsFormat

## org.apache.lucene.codecs.Codec

```
org.apache.lucene.codecs.asserting.AssertingCodec
org.apache.lucene.codecs.cheapbastard.CheapBastardCodec
org.apache.lucene.codecs.compressing.FastCompressingCodec
org.apache.lucene.codecs.compressing.FastDecompressionCompressingCodec
org.apache.lucene.codecs.compressing.HighCompressionCompressingCodec
org.apache.lucene.codecs.compressing.dummy.DummyCompressingCodec
```

## org.apache.lucene.codecs.DocValuesFormat

```
org.apache.lucene.codecs.asserting.AssertingDocValuesFormat
```

## org.apache.lucene.codecs.PostingsFormat

```
org.apache.lucene.codecs.mockrandom.MockRandomPostingsFormat
org.apache.lucene.codecs.ramonly.RAMOnlyPostingsFormat
org.apache.lucene.codecs.blockterms.LuceneFixedGap
org.apache.lucene.codecs.blockterms.LuceneVarGapFixedInterval
org.apache.lucene.codecs.blockterms.LuceneVarGapDocFreqInterval
org.apache.lucene.codecs.bloom.TestBloomFilteredLucenePostings
org.apache.lucene.codecs.asserting.AssertingPostingsFormat
```
