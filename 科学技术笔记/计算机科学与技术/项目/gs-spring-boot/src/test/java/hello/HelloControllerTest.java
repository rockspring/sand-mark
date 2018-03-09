package hello;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MockServletContext.class, Application.class})
@WebAppConfiguration
@Component
public class HelloControllerTest {

	private MockMvc mvc;

    @Autowired
    private ColumnDAO columnDAO;


	@Before
	public void setUp() throws Exception {
		//mvc = MockMvcBuilders.standaloneSetup(new HelloController(jdbcTemplate)).build();
	}

	@Test
	public void getHello() throws Exception {
		//mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
		//		.andExpect(status().isOk())
		//		.andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	}

    @Test
    public void test() {
        for (int i=0; i < 64; ++i) {
            if (i<10) {
                System.out.format("uesearch_index0%d\n", i);
            } else {
                System.out.format("uesearch_index%d\n", i);
            }
        }

        byte[] bytes = new byte[8];


        BigInteger bigInteger = new BigInteger("1000000000000000000000000000000000000000000000000000000000000000",2);
        System.out.println(bigInteger);
        System.out.println(bigInteger.shiftRight(63));

        System.out.println(getTableName(bigInteger));
    }

    /**
     *
     * @param typeId 索引数据源类型ID，取值范围[0,64)
     * @param cityId 城市ID，取值范围[0,4096)
     * @param sourceId 索引数据源来源ID，取值范围[0,64)
     * @param dataId 索引数据源数据ID，取值范围[0,1099511627776)
     * @return
     */
    public static BigInteger getUesearchIndexDataId(int typeId, int cityId, int sourceId, long dataId) {
        BigInteger bigTypeId = BigInteger.valueOf(typeId);
        BigInteger bigCityId = BigInteger.valueOf(cityId);
        BigInteger bigSourceId = BigInteger.valueOf(sourceId);
        BigInteger bigDataId = BigInteger.valueOf(dataId);

        BigInteger id = bigTypeId.shiftLeft(58);
        id = id.add(bigCityId.shiftLeft(52).shiftRight(6));
        id = id.add(bigSourceId.shiftLeft(58).shiftRight(18));
        id = id.add(bigDataId.shiftLeft(24).shiftRight(24));

        return id;
    }

    /**
     *
     * @param typeId 索引数据源类型ID，取值范围[0,64)
     * @param cityId 城市ID，取值范围[0,4096)
     * @param sourceId 索引数据源来源ID，取值范围[0,64)
     * @param dataId 索引数据源数据ID，取值范围[0,1099511627776)
     * @return
     */
    public static long getUesearchIndexDataIdV2(long typeId, long cityId, long sourceId, long dataId) {


        return typeId << 58 | cityId << 46 | sourceId << 40 | dataId;
    }

    @Test
    public void testGetUesearchIndexDataIdV2() {
        int typeId = 32;
        int cityId = 0;
        int sourceId = 0;
        long dataId = 0L;

        long id = getUesearchIndexDataIdV2(typeId, cityId, sourceId, dataId);

        String expectedString = "";


        Assert.assertEquals("0", Long.toBinaryString(id));
    }

    @Test
    public void testGetUesearchIndexDataIdCase1() {
        int typeId = 0;
        int cityId = 0;
        int sourceId = 0;
        long dataId = 0L;

        BigInteger id = getUesearchIndexDataId(typeId, cityId, sourceId, dataId);

        String expectedString = "";

        for (int i=0; i< 63; i++) {
            expectedString += "0";
        }

        Assert.assertEquals("0", id.toString(2));
    }

    @Test
    public void testGetUesearchIndexDataIdCase2() {
        int typeId = 63;
        int cityId = 4095;
        int sourceId = 63;
        long dataId = 1099511627775L;

        BigInteger id = getUesearchIndexDataId(typeId, cityId, sourceId, dataId);

        String expectedString = "";

        for (int i=0; i< 64; i++) {
            expectedString += "1";
        }

        Assert.assertEquals(expectedString, id.toString(2));
    }

    @Test
    public void testGetUesearchIndexDataIdCase3() {
        int typeId = 63;
        int cityId = 4095;
        int sourceId = 0;
        long dataId = 1099511627775L;

        BigInteger id = getUesearchIndexDataId(typeId, cityId, sourceId, dataId);

        String expectedString = "";

        for (int i=0; i< 18; i++) {
            expectedString += "1";
        }

        expectedString += "000000";

        for (int i=24; i< 64; i++) {
            expectedString += "1";
        }

        System.out.println(id.toString(2));

        Assert.assertEquals(expectedString, id.toString(2));
    }

    public static String getTableName(BigInteger id) {
        int tableNo = id.shiftLeft(59).intValue();

        String tableSuffix = tableNo < 10 ? "0" + tableNo : "" + tableNo;

        return "uesearch_index" + tableSuffix;
    }

    public static String toCamal(String text) {
        boolean wordStart = false;

        char[] newText = new char[text.length()];

        int j=0;
        for (int i=0; i < text.length(); i++) {
            if ('_' == text.charAt(i)) {
                wordStart = true;
                continue;
            }
            if (wordStart) {
                newText[j++] = Character.toUpperCase(text.charAt(i));
                wordStart = false;
            } else {
                newText[j++] = Character.toLowerCase(text.charAt(i));
            }
        }

        return String.copyValueOf(newText, 0 , j);
    }

    @Test
    public void testToCamal() {
        String text = "COLUMN_NAME";
        System.out.println(toCamal(text));

        Assert.assertEquals("columnName", toCamal(text));
    }

    @Test
    public void testColumnDAO() {
        Map<String, String> dataTypes = new HashMap<>();
        dataTypes.put("tinyint","int");
        dataTypes.put("smallint","int");
        dataTypes.put("mediumint","int");
        dataTypes.put("int","int");
        dataTypes.put("bigint","long");
        dataTypes.put("float","float");
        dataTypes.put("double","double");
        dataTypes.put("real", "dobule");
        dataTypes.put("decimal","BigDecimal");
        dataTypes.put("numeric", "BigDcimal");
        dataTypes.put("bit","long"); //最大64 bits
        dataTypes.put("date","Date");
        dataTypes.put("time","Date");
        dataTypes.put("datetime","TimeStamp");
        dataTypes.put("timestamp","TimeStamp");
        dataTypes.put("year","Date");
        dataTypes.put("char","String");
        dataTypes.put("binary","byte[]");
        dataTypes.put("varchar","String");
        dataTypes.put("varbinary","byte[]");
        dataTypes.put("tinyblob","byte[]");
        dataTypes.put("tinytext","String");
        dataTypes.put("blob","byte[]");
        dataTypes.put("text","String");
        dataTypes.put("mediumblob","byte[]");
        dataTypes.put("mediumtext","String");
        dataTypes.put("longblob","byte[]");
        dataTypes.put("longtext","String");
        dataTypes.put("enum","Enum");// 最多65,535个
        dataTypes.put("set","Set"); // 最多64个
        List<Map<String, Object>> result = (List<Map<String, Object>>)columnDAO.test();
        for (Map<String, Object> column : result) {
            System.out.println("private " + dataTypes.get((String)column.get("DATA_TYPE")) + " " + toCamal((String)column.get("COLUMN_NAME")) + "; // " + column.get("COLUMN_COMMENT"));
        }
    }
}
