import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.TokenizerAnnotator;
import edu.stanford.nlp.process.Tokenizer;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by zlq on 9/20/16.
 */
public class TokenizerAnnotatorDemo {
    private static TokenizerAnnotatorDemo instance;
    private CRFClassifier classifier;

    private TokenizerAnnotatorDemo(){
        Properties props = new Properties();
        props.setProperty("sighanCorporaDict", "data");
        props.setProperty("serDictionary", "data/dict-chris6.ser.gz");
        props.setProperty("inputEncoding", "UTF-8");
        props.setProperty("sighanPostProcessing", "true");
        classifier = new CRFClassifier(props);
        classifier.loadClassifierNoExceptions("data/ctb.gz", props);
        classifier.flags.setProperties(props);
    }

    public static TokenizerAnnotatorDemo getInstance() {
        if (instance == null) {
            instance = new TokenizerAnnotatorDemo();
        }

        return instance;
    }

    public String[] doSegment(String data) {
        return (String[]) classifier.segmentString(data).toArray();
    }

    public static void main(String args[]) {
        TokenizerAnnotator tokenizerAnnotator = new TokenizerAnnotator();
        Tokenizer<CoreLabel> tokenizer =tokenizerAnnotator.getTokenizer(new BufferedReader(new InputStreamReader(new
                ByteArrayInputStream
                ("中华人民共和国我是中国人"
                .getBytes()))));

        CoreLabel coreLabel = tokenizer.next();
        System.out.println(coreLabel.toString());

        /*ChineseSegmenterAnnotator chineseSegmenterAnnotator = new ChineseSegmenterAnnotator();

        List<CoreMap> sentences = new ArrayList<>();
        Annotation annotation = new Annotation();
        chineseSegmenterAnnotator.annotate(annotation);*/


        String sentence = "蓼水河，是位于中国湖南省绥宁县、洞口县的一条河流，汇入赧水，属于资水水系。河长97千米，流域面积1141平方千米，多年平均流量29立方米每秒。自然落差667米。水能理论蕴藏量3万千瓦。";

        //sentence = "请问一下在重庆买套二手二手房过户费用是否全部买方出卖方不出找哪个部门解决";

        //sentence = "重庆重庆市赁租房公租房到哪里申请需要哪些手续";

        System.out.println(System.nanoTime());

        TokenizerAnnotatorDemo tokenizerAnnotatorDemo = TokenizerAnnotatorDemo.getInstance();

        System.out.println(System.nanoTime());

        for (int i =0; i<1000; i++) {
            long start = System.nanoTime();
            String ret[] = tokenizerAnnotatorDemo.doSegment(sentence);
            long end = System.nanoTime();
            System.out.println((end-start)/1000000 + " ms");
            for (String str : ret) {
                //System.out.println(str);
            }
        }
    }
}
