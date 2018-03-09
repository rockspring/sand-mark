/**
 * Created by zlq on 4/7/16.
 */
public class Test {

    @org.junit.Test
    public void test1() {
        String fileName = "out.2016-04-08-16";
        for (int i=0; i<200; ++i) {
            int lower = i*10;
            int upper = i*10 + 9;
            System.out.println("cat "+fileName+" | awk -F \",\"  '$4>="+lower+" && $4<="+(upper)+"{print $0}' " +
                    ">"+fileName+"."
                    + lower +"_"
                    + (upper));
        }


        for (int i=0; i<200; ++i) {
            int lower = i*10;
            int upper = i*10 + 9;
            System.out.println("wc -l "+fileName+"."
                    + lower +"_"
                    + (upper) + " >> result.txt");
        }
        System.exit(1);

        for (int i=20; i<30; ++i) {
            int lower = i*10;
            int upper = i*10 + 9;
            System.out.println("cat "+fileName+" | awk -F \",\"  '$4>="+lower+" && $4<="+(upper)+"{print $0}' " +
                    ">"+fileName+"."
                    + lower +"_"
                    + (upper));
        }

        for (int i=20; i<30; ++i) {
            int lower = i*10;
            int upper = i*10 + 9;
            System.out.println("wc -l "+fileName+"."
                    + lower +"_"
                    + (upper) + " >> result.txt");
        }

        for (int i=30; i<40; ++i) {
            int lower = i*10;
            int upper = i*10 + 9;
            System.out.println("cat "+fileName+" | awk -F \",\"  '$4>="+lower+" && $4<="+(upper)+"{print $0}' " +
                    ">"+fileName+"."
                    + lower +"_"
                    + (upper));
        }

        for (int i=30; i<40; ++i) {
            int lower = i*10;
            int upper = i*10 + 9;
            System.out.println("wc -l "+fileName+"."
                    + lower +"_"
                    + (upper) + " >> result.txt");
        }

        for (int i=40; i<100; ++i) {
            int lower = i*10;
            int upper = i*10 + 9;
            System.out.println("cat "+fileName+" | awk -F \",\"  '$4>="+lower+" && $4<="+(upper)+"{print $0}' " +
                    ">"+fileName+"."
                    + lower +"_"
                    + (upper));
        }

        for (int i=40; i<100; ++i) {
            int lower = i*10;
            int upper = i*10 + 9;
            System.out.println("wc -l "+fileName+"."
                    + lower +"_"
                    + (upper) + " >> result.txt");
        }
    }

    @org.junit.Test
    public void test2() {
        float equalPrice = 1.0f;
        float andPrice = 1.0f; //个数
        float orPrice = 1.0f;//个数
        float rangePrice = 2.0f;
        float facetPrice = 3.0f;//考虑个数
        float keywordsPrice = 4.0f;

        float distancePrice = 5.0f;
        float geoRangePrice = 6.0f;

        float startPrice = 1.0f;
        float rowsPrice = 1.0f;

        float fieldCountPrice = 1.0f;

        float sorttestPrice = 1.0f;
        float sortrandPrice = 2.0f;
        float sortrandbPrice = 2.0f;
        float sortweightrandPrice = 2.0f;
        float sortrandrealPrice = 2.0f;
        float sortauctionrandPrice = 2.0f;
        float sortboostPrice = 3.0f;

        int equalCount = 0;
        int andCount = 0;
        int orCount = 0;
        int rangeCount = 0;
        int facetCount = 0;
        int keywordsCount = 0;

        int distanceCount = 0;
        int geoRangeCount = 0;

        int startCount = 0;
        int rowsCount = 0;

        int fieldCountCount = 0;

        int sorttestCount = 0;
        int sortrandCount = 0;
        int sortrandbCount = 0;
        int sortweightrandCount = 0;
        int sortrandrealCount = 0;
        int sortauctionrandCount = 0;
        int sortboostCount = 0;

        String query = "cookieid=078a103f-8ec6-cc6d-af19-263250ebfcc6&city_id=11&info_type=1&blat=30.79805_31.434172&blng=121.076582_122.203416&is_list=1&info_source=1|3|8&facet=community_id:&start=0&size=25&sort=sortrand_desc";

        String[] queryItems = query.split("&");

        for (String queryItem : queryItems) {
            //System.out.println(queryItem);
            int valueIndex = queryItem.indexOf("=");
            String key;
            String value;
            if (valueIndex >0 && valueIndex < queryItem.length()) {
                key = queryItem.substring(0, valueIndex);
                value = queryItem.substring(valueIndex+1);
                System.out.println(key);
                System.out.println(value);

                // key是一个esearch字段
                if (value.contains("|")) {
                    orCount++;
                }
                if (value.contains(",")) {
                    andCount++;
                }
                if (value.contains("_")) {

                }
            }
        }
    }
}
