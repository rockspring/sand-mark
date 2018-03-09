import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by zlq on 5/5/15.
 */
public class PinYinTool {
    @Test
    public void testHanZi2PinYin() throws Exception{
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("city_name.txt");

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        while (null != (line =bufferedReader.readLine())) {
            //System.out.println(line);
            System.out.print(line + " -- ");

            if (line.contains("/")) {
                String[] parts = line.split("/");
                for (String part : parts) {
                    HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
                    //format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
                    format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

                    for (int i = 0; i<part.length(); i++) {

                        String[] pinYins = PinyinHelper.toHanyuPinyinStringArray(part.charAt(i));
                        for (int j=0; j < pinYins.length; j++) {
                            System.out.print(pinYins[j]);
                            if (j < pinYins.length -1) {
                                System.out.print(",");
                            }
                        }

                        if (i < part.length()) {
                            System.out.print(" -- ");
                        }
                    }
                }

                System.out.print("去掉声调 -- ");

                for (String part : parts) {
                    HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
                    //format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
                    format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

                    for (int i = 0; i<part.length(); i++) {

                        String[] pinYins = PinyinHelper.toHanyuPinyinStringArray(part.charAt(i), format);
                        for (int j=0; j < pinYins.length; j++) {
                            System.out.print(pinYins[j]);
                            if (j < pinYins.length -1) {
                                System.out.print(",");
                            }
                        }

                        if (i < part.length() -1 ) {
                            System.out.print(" -- ");
                        }
                    }
                    //System.out.print("/");
                }
                System.out.println();

                continue;
            }

            for (int i = 0; i<line.length(); i++) {

                String[] pinYins = PinyinHelper.toHanyuPinyinStringArray(line.charAt(i));
                for (int j=0; j < pinYins.length; j++) {
                    System.out.print(pinYins[j]);
                    if (j < pinYins.length -1) {
                        System.out.print(",");
                    }
                }

                if (i < line.length()) {
                    System.out.print(" -- ");
                }
            }
            System.out.print("去掉声调 -- ");

            for (int i = 0; i<line.length(); i++) {
                HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
                //format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
                format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

                String[] pinYins = PinyinHelper.toHanyuPinyinStringArray(line.charAt(i), format);
                for (int j=0; j < pinYins.length; j++) {
                    System.out.print(pinYins[j]);
                    if (j < pinYins.length -1) {
                        System.out.print(",");
                    }
                }

                if (i < line.length() -1) {
                    System.out.print(" -- ");
                }
            }
            System.out.println();
        }
    }

    @Test
    public void testHanZi2PinYin4Province() throws Exception{
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("province_name.txt");

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        while (null != (line =bufferedReader.readLine())) {
            //System.out.println(line);
            System.out.print(line + " -- ");

            if (line.contains("/")) {
                String[] parts = line.split("/");
                for (String part : parts) {
                    HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
                    //format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
                    format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

                    for (int i = 0; i<part.length(); i++) {

                        String[] pinYins = PinyinHelper.toHanyuPinyinStringArray(part.charAt(i));
                        for (int j=0; j < pinYins.length; j++) {
                            System.out.print(pinYins[j]);
                            if (j < pinYins.length -1) {
                                System.out.print(",");
                            }
                        }

                        if (i < part.length()) {
                            System.out.print(" -- ");
                        }
                    }
                }

                System.out.print("去掉声调 -- ");

                for (String part : parts) {
                    HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
                    //format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
                    format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

                    for (int i = 0; i<part.length(); i++) {

                        String[] pinYins = PinyinHelper.toHanyuPinyinStringArray(part.charAt(i), format);
                        for (int j=0; j < pinYins.length; j++) {
                            System.out.print(pinYins[j]);
                            if (j < pinYins.length -1) {
                                System.out.print(",");
                            }
                        }

                        if (i < part.length() -1 ) {
                            System.out.print(" -- ");
                        }
                    }
                    //System.out.print("/");
                }
                System.out.println();

                continue;
            }

            for (int i = 0; i<line.length(); i++) {

                String[] pinYins = PinyinHelper.toHanyuPinyinStringArray(line.charAt(i));
                for (int j=0; j < pinYins.length; j++) {
                    System.out.print(pinYins[j]);
                    if (j < pinYins.length -1) {
                        System.out.print(",");
                    }
                }

                if (i < line.length()) {
                    System.out.print(" -- ");
                }
            }
            System.out.print("去掉声调 -- ");

            for (int i = 0; i<line.length(); i++) {
                HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
                //format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
                format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

                String[] pinYins = PinyinHelper.toHanyuPinyinStringArray(line.charAt(i), format);
                for (int j=0; j < pinYins.length; j++) {
                    System.out.print(pinYins[j]);
                    if (j < pinYins.length -1) {
                        System.out.print(",");
                    }
                }

                if (i < line.length() -1) {
                    System.out.print(" -- ");
                }
            }
            System.out.println();
        }
    }

    @Test
    public void testHanZi2PinYin4City() throws Exception{
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("city_name_pinyin.single.txt");

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        while (null != (line =bufferedReader.readLine())) {
            //System.out.println(line);
            //System.out.print(line + " -- ");
            System.out.print(line.substring(0, line.indexOf(" ")) + "\t");

            String pinYinPart = line.substring(line.indexOf("去掉声调")+4);

            String[] parts = pinYinPart.split(" ");
            for (String part: parts) {
                if (part.equals("--") || part.trim().equals("")) {
                    continue;
                }

                //System.out.println(part);

                System.out.print(part.substring(0, 1).toUpperCase() + part.substring(1));
            }
            //System.out.println(pinYinPart);
            System.out.println();
        }
    }

    @Test
    public void testHanZi2PinYin4ProvinceZuHe() throws Exception{
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("province_name_pinyin.single.txt");

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        while (null != (line =bufferedReader.readLine())) {
            //System.out.println(line);
            //System.out.print(line + " -- ");
            System.out.print(line.substring(0, line.indexOf(" ")) + "\t");

            String pinYinPart = line.substring(line.indexOf("去掉声调")+4);

            String[] parts = pinYinPart.split(" ");
            for (String part: parts) {
                if (part.equals("--") || part.trim().equals("")) {
                    continue;
                }

                //System.out.println(part);

                System.out.print(part.substring(0, 1).toUpperCase() + part.substring(1));
            }
            //System.out.println(pinYinPart);
            System.out.println();
        }
    }
}
