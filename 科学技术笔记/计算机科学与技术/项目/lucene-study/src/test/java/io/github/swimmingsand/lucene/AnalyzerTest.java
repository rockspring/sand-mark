package io.github.swimmingsand.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.FlagsAttribute;
import org.apache.lucene.analysis.tokenattributes.KeywordAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionLengthAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by zlq on 4/28/15.
 */
public class AnalyzerTest {

    @Test
    public void testAnalyzer() throws IOException{
        System.out.println( "Hello World!" );
        Analyzer analyzer = new StandardAnalyzer();
        Analyzer analyzer1 = new Analyzer() {
            @Override
            protected TokenStreamComponents createComponents(String fieldName) {
                //return null;
                //TokenStreamComponents tokenStreamComponents = new TokenStreamComponents(new LetterTokenizer());
                TokenStreamComponents tokenStreamComponents = new TokenStreamComponents(new StandardTokenizer());
                return tokenStreamComponents;
            }
        };
        //Analyzer analyzer = new WhitespaceAnalyzer(Version.LUCENE_47);
        //Analyzer analyzer = new KeywordAnalyzer();
        //Analyzer analyzer = new SimpleAnalyzer();
        try {
            TokenStream tokenStream = analyzer1.tokenStream("a", "123position中 a&文");
            CharTermAttribute charTerm =tokenStream.addAttribute(CharTermAttribute.class);
            FlagsAttribute flagsAttribute = tokenStream.addAttribute(FlagsAttribute.class);
            KeywordAttribute keywordAttribute = tokenStream.addAttribute(KeywordAttribute.class);
            OffsetAttribute offsetAttribute = tokenStream.addAttribute(OffsetAttribute.class);
            PositionIncrementAttribute positionIncrementAttribute = tokenStream.addAttribute(PositionIncrementAttribute.class);
            PositionLengthAttribute positionLengthAttribute = tokenStream.addAttribute(PositionLengthAttribute.class);
            TypeAttribute typeAttribute = tokenStream.addAttribute(TypeAttribute.class);
            tokenStream.reset();
            while (tokenStream.incrementToken()) {
                System.out.print(charTerm.toString());
                System.out.printf(" flagsAttribute:%s ",flagsAttribute.getFlags());
                System.out.printf("keywordAttribute:%s ",keywordAttribute.isKeyword());
                System.out.printf("start:%d end:%d ",offsetAttribute.startOffset(),offsetAttribute.endOffset());
                System.out.printf("positionIncrement:%d ",positionIncrementAttribute.getPositionIncrement());
                System.out.printf("positionLength:%d ",positionLengthAttribute.getPositionLength());
                System.out.printf("typeAttribute:%s\n",typeAttribute.type());
            }
            tokenStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
