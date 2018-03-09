package io.github.swimmingsand.lucene;

import com.chenlb.mmseg4j.ComplexSeg;
import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.MMSeg;
import com.chenlb.mmseg4j.Seg;
import com.chenlb.mmseg4j.Word;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.FlagsAttribute;
import org.apache.lucene.analysis.tokenattributes.KeywordAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionLengthAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.apache.lucene.codecs.Codec;
import org.apache.lucene.codecs.simpletext.SimpleTextCodec;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void segmentUseMMSeg() throws Exception{
        StringBuilder sb = new StringBuilder();
        Dictionary dic = Dictionary.getInstance();
        Seg seg = new ComplexSeg(dic);	//取得不同的分词具体算法
        MMSeg mmSeg = new MMSeg(new StringReader("取得不同的分词具体算法"), seg);
        Word word = null;
        boolean first = true;
        String wordSpilt =" ";
        try {
            while((word=mmSeg.next())!=null) {
                if(!first) {
                    sb.append(wordSpilt);
                }
                String w = word.getString();
                sb.append(w);
                first = false;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }

    public static void solrStandardAnalyzer(){
        System.out.println( "Hello World!" );
        //Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_47);
        //Analyzer analyzer = new WhitespaceAnalyzer(Version.LUCENE_47);
        //Analyzer analyzer = new KeywordAnalyzer();
        Analyzer analyzer = new SimpleAnalyzer();
        try {
            TokenStream tokenStream = analyzer.tokenStream("a", "1中 a&文");
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

    @Test
    public void testApp() throws Exception{
        SimpleTextCodec simpleTextCodec;
        Codec.forName("SimpleText");
        BigDecimal decimal = new BigDecimal(1);
        decimal.divide(new BigDecimal(1), BigDecimal.ROUND_UNNECESSARY);
    }
}
