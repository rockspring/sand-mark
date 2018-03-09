package io.github.swimmingsand;

import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;

import java.io.PrintStream;
import java.util.List;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String basedir = System.getProperty("SegDemo", "/Users/zlq/Projects/incubator/stanford-segmenter-2015-04-20/data");
    /**
     *    -sighanCorporaDict ./data -textFile test.simp.utf8 -inputEncoding UTF-8 -sighanPostProcessing true -keepAllWhitespaces true -loadClassifier ./data/ctb.gz -serDictionary ./data/dict-chris6.ser.gz
     * @param args
     */
    public static void main( String[] args ) throws Exception {
        System.out.println( "Hello World!" );
        System.setOut(new PrintStream(System.out, true, "utf-8"));

        Properties props = new Properties();
        props.setProperty("sighanCorporaDict", basedir);
        // props.setProperty("NormalizationTable", "data/norm.simp.utf8");
        // props.setProperty("normTableEncoding", "UTF-8");
        // below is needed because CTBSegDocumentIteratorFactory accesses it
        props.setProperty("serDictionary", basedir + "/dict-chris6.ser.gz");
        if (args.length > 0) {
            props.setProperty("testFile", args[0]);
        }
        props.setProperty("inputEncoding", "UTF-8");
        props.setProperty("sighanPostProcessing", "true");

        CRFClassifier<CoreLabel> segmenter = new CRFClassifier<CoreLabel>(props);
        //segmenter.loadClassifierNoExceptions(basedir + "/ctb.gz", props);
        segmenter.loadClassifierNoExceptions(basedir + "/pku.gz", props);
        for (String filename : args) {
            segmenter.classifyAndWriteAnswers(filename);
        }

        String sample = "万达二号公寓";
        sample = "阳光锦城 自住环保装修 两房 雨花亭商圈".replace(" ","");
        List<String> segmented = segmenter.segmentString(sample);
        System.out.println(segmented);

        sample = "富湾国际高品质住宅江景房全明户型带豪华装修含车位，拎包入住".replace(" ","");
        segmented = segmenter.segmentString(sample);
        System.out.println(segmented);

        sample = "稀缺豪装3房拎包入 朝南送入户花园 住带砂子塘指标 万博汇".replace(" ","");
        segmented = segmenter.segmentString(sample);
        System.out.println(segmented);

        sample = "和记黄埔开发，150平花园中间，安静叠墅 南北通透".replace(" ","");
        segmented = segmenter.segmentString(sample);
        System.out.println(segmented);
    }
}
