package io.github.swimmingsand.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.payloads.DelimitedPayloadTokenFilter;
import org.apache.lucene.analysis.payloads.PayloadEncoder;

/**
 * Created by zlq on 5/20/15.
 */
class PayloadAnalyzer extends Analyzer {

    private PayloadEncoder encoder;



    PayloadAnalyzer(PayloadEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        Tokenizer source = new WhitespaceTokenizer();

        TokenStream filter = new LowerCaseFilter(source);

        filter = new DelimitedPayloadTokenFilter(filter, '|', encoder);
        return new TokenStreamComponents(source, filter);
    }
}

