package io.github.swimmingsand.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.payloads.NumericPayloadTokenFilter;
import org.apache.lucene.analysis.payloads.PayloadEncoder;

/**
 * Created by zlq on 5/20/15.
 */
class PayloadAnalyzer2 extends Analyzer {

    private PayloadEncoder encoder;



    PayloadAnalyzer2(PayloadEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        Tokenizer source = new WhitespaceTokenizer();

        TokenStream filter = new LowerCaseFilter(source);

        //filter = new DelimitedPayloadTokenFilter(filter, '|', encoder);
        filter = new NumericPayloadTokenFilter(filter, 20, "word");
        return new TokenStreamComponents(source, filter);
    }
}
