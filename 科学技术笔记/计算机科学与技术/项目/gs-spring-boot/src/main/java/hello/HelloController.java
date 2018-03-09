package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;
import org.springframework.mobile.device.Device;

import javax.sql.DataSource;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Controller
public class HelloController {

    //private final JdbcTemplate jdbcTemplate;


    @Autowired
    private DataSource zufangDataSource;

    @Autowired
    private ColumnDAO columnDAO;

    @Autowired
    private ZufangDAO zufangDAO;

    @Autowired
    private CommunityDAO communityDAO;

    @Autowired
    CommunityIndexSourceDocRepository communityIndexSourceDocRepository;
    /*@Autowired
    public HelloController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        List<Map<String, Object>> result = jdbcTemplate.queryForList("select * from blog");
        return String.valueOf(result.size());
        //return "Greetings from Spring Boot!";
    }**/

    @RequestMapping("/page")
    public String page(Model model) {
        model.addAttribute("data", "周乐钦");
        return "index";
    }

    @RequestMapping(value = "/zufang-datasource", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String zufangDatasource() throws Exception {
        return zufangDataSource.getConnection().getMetaData().getURL();
    }

    @RequestMapping(value = "/databaseProductName", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String databaseProductName() throws Exception {
        return zufangDAO.getDataBaseName();
    }


    @RequestMapping(value = "/community/{userId}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Object community(@PathVariable(value = "userId") Integer userId) throws Exception {
        return communityDAO.findById(userId);
    }

    @RequestMapping(value = "/community/search", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Object searchCommunity() throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<>();

        params.put("m", "s");

        params.put("page", "1");
        params.put("size", "100");
        params.put("pk_name", "id");
        params.put("multi_fields", "school_id,usetype,other_name,metro_lines");
        params.put("fields", "cityid,areacode,name,address,icon_img,sale_num,rent_num,img_num,thread_num," +
                "hits_num,letter,forum_id,house_type,nh_num,area_string,sub_area_string,mapx,mapy,integrity," +
                "goodpic_num,goodmodel_num,showcommexpert,match_name,alias_name,is_internal,other_name,school_id," +
                "glat,glng,opstate,senddate,greenpert,usetype,housetotal,buildarea,commbuilder,metro_lines,blat," +
                "blng,pinyin,defname,defpinyin,mid_price,mid_change");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("sort=sale_num_desc");
        queryBuilder.append("&");
        queryBuilder.append("cityid_11=1");
        params.put("query", queryBuilder.toString());

        URL url =new URL("http://10.20.3.9:9090/search/community");

        StringBuilder queryParamsBuilder = new StringBuilder("http://10.20.3.9:9090/search/community?");
        boolean isFirstParam = true;
        for (String key: params.keySet()) {
            if (isFirstParam) {
                queryParamsBuilder.append(key + "=");
                isFirstParam = false;
            } else {
                queryParamsBuilder.append("&" + key + "=");
            }

            queryParamsBuilder.append(UriUtils.encodeQueryParam(params.get(key), "utf-8"));
        }





        return restTemplate.getForObject(queryParamsBuilder.toString(), Map.class);
    }

    @RequestMapping(value = "/community/search/url", produces = "application/html; charset=utf-8")
    public Object searchCommunityUrl(Model model) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<>();

        params.put("m", "s");

        params.put("pk_name", "id");
        params.put("multi_fields", "school_id,usetype,other_name,metro_lines");


        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("sort=sale_num_desc");
        queryBuilder.append(UriUtils.encodeQueryParam("&", "utf-8"));
        queryBuilder.append("cityid_11=1");
        queryBuilder.append(UriUtils.encodeQueryParam("&", "utf-8"));
        queryBuilder.append("fields=cityid,areacode,name,address,icon_img,sale_num,rent_num,img_num,thread_num," +
                "hits_num,letter,forum_id,house_type,nh_num,area_string,sub_area_string,mapx,mapy,integrity," +
                "goodpic_num,goodmodel_num,showcommexpert,match_name,alias_name,is_internal,other_name,school_id," +
                "glat,glng,opstate,senddate,greenpert,usetype,housetotal,buildarea,commbuilder,metro_lines,blat," +
                "blng,pinyin,defname,defpinyin,mid_price,mid_change");
        queryBuilder.append(UriUtils.encodeQueryParam("&", "utf-8"));
        queryBuilder.append("page=1");

        queryBuilder.append(UriUtils.encodeQueryParam("&", "utf-8"));
        queryBuilder.append("size=100");

        params.put("query", queryBuilder.toString());

        URL url =new URL("http://10.20.3.9:9090/search/community");

        StringBuilder queryParamsBuilder = new StringBuilder("http://10.20.3.9:9090/search/community?");
        boolean isFirstParam = true;
        for (String key: params.keySet()) {
            if (isFirstParam) {
                queryParamsBuilder.append(key + "=");
                isFirstParam = false;
            } else {
                queryParamsBuilder.append("&" + key + "=");
            }

            queryParamsBuilder.append(params.get(key));
        }

        model.addAttribute("url", queryParamsBuilder.toString());


        Map<String, String> solrParams = new HashMap<>();

        solrParams.put("q", "*:*");
        solrParams.put("fl", "*");
        solrParams.put("fq", "cityid:11");
        solrParams.put("sort" , "sale_num desc");
        solrParams.put("start", "0");
        solrParams.put("rows", "100");


        StringBuilder SorQueryParamsBuilder = new StringBuilder("http://solr.anjuke.test:8983/community35/select?");
        isFirstParam = true;
        for (String key: solrParams.keySet()) {
            if (isFirstParam) {
                SorQueryParamsBuilder.append(key + "=");
                isFirstParam = false;
            } else {
                SorQueryParamsBuilder.append("&" + key + "=");
            }

            SorQueryParamsBuilder.append(solrParams.get(key));
        }

        model.addAttribute("solr_url", SorQueryParamsBuilder.toString());



        return "community";
    }

    @RequestMapping("/detect-device")
    public @ResponseBody String detectDevice(Device device) {
        String deviceType = "unknown";
        if (device.isNormal()) {
            deviceType = "normal";
        } else if (device.isMobile()) {
            deviceType = "mobile";
        } else if (device.isTablet()) {
            deviceType = "tablet";
        }
        return "Hello " + deviceType + " browser!";
    }

    @RequestMapping("/columns/columns")
    public @ResponseBody Object getColumns() {
        return columnDAO.test();
    }

    @RequestMapping("/solr")
    public @ResponseBody Object getSolr() {
        return communityIndexSourceDocRepository.findAll(new Pageable() {
            @Override
            public int getPageNumber() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return 10;
            }

            @Override
            public int getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        });
    }

    @RequestMapping("/schema")
    public @ResponseBody Map<String, Object> testIndexSourceSchema() {
        Map<String, String> dataTypes = new HashMap<>();
        dataTypes.put("tinyint","int32_t");
        dataTypes.put("smallint","int32_t");
        dataTypes.put("mediumint","int32_t");
        dataTypes.put("int","int32_t");
        dataTypes.put("bigint","int64_t");
        dataTypes.put("float","float");
        dataTypes.put("double","double");
        dataTypes.put("real", "double");
        dataTypes.put("decimal","double");
        dataTypes.put("numeric", "double");
        dataTypes.put("bit","long"); //最大64 bits
        dataTypes.put("date","Date");
        dataTypes.put("time","Date");
        dataTypes.put("datetime","TimeStamp");
        dataTypes.put("timestamp","TimeStamp");
        dataTypes.put("year","Date");
        dataTypes.put("char","string");
        dataTypes.put("binary","byte[]");
        dataTypes.put("varchar","string");
        dataTypes.put("varbinary","byte[]");
        dataTypes.put("tinyblob","byte[]");
        dataTypes.put("tinytext","string");
        dataTypes.put("blob","byte[]");
        dataTypes.put("text","string");
        dataTypes.put("mediumblob","byte[]");
        dataTypes.put("mediumtext","string");
        dataTypes.put("longblob","byte[]");
        dataTypes.put("longtext","string");
        dataTypes.put("enum","Enum");// 最多65,535个
        dataTypes.put("set","Set"); // 最多64个

        Set<String> rangeFields = new HashSet<>();
        rangeFields.add("area_num");
        rangeFields.add("total_price");
        rangeFields.add("area_num");
        rangeFields.add("area_num");
        rangeFields.add("area_num");

        List<Map<String, Object>> result = (List<Map<String, Object>>)columnDAO.getColumns("index_source_000");

        List<Map<String, Object>> fields = new ArrayList<>();
        List<Map<String, String>> index = new ArrayList<>();
        List<Map<String, String>> store = new ArrayList<>();

        TreeMap<String, Object> schema = new TreeMap<>();

        for (Map<String, Object> column : result) {
            String schemaFieldType = dataTypes.get((String)column.get("DATA_TYPE"));
            String schemaFiledName = (String)column.get("COLUMN_NAME");
            String comment = (String)column.get("COLUMN_COMMENT");
            String columnKey = (String)column.get("COLUMN_KEY");

            boolean isUnique = false;

            if (columnKey.equals("UNI")) {
                isUnique = true;
            }

            boolean isMultiValued = false;

            if (comment.contains("json多值")) {
                isMultiValued = true;
            }

            Map<String, Object> field = new HashMap<>();
            field.put("field_name", schemaFiledName);
            field.put("field_type", schemaFieldType);

            if (rangeFields.contains(schemaFiledName)) {
                field.put("support_range", true);
            }

            if (isMultiValued) {
                field.put("multi_value", true);
            }

            if (isUnique) {
                field.put("field_type", "uint64_t");
                field.put("primary_key", true);
            }
            fields.add(field);

            // index
            Map<String, String> indexItem = new HashMap<>();
            indexItem.put("package_name", schemaFiledName);
            indexItem.put("package_fields", schemaFiledName);
            index.add(indexItem);


            // store
            Map<String, String> storeItem = new HashMap<>();
            storeItem.put("field_name", schemaFiledName);
            store.add(storeItem);
        }

        schema.put("fields", fields);
        schema.put("index", index);
        schema.put("store", store);

        return schema;
    }

    @RequestMapping("/multi-value")
    public @ResponseBody List<String> testIndexSourceSchemaMultiValues() {
        Map<String, String> dataTypes = new HashMap<>();
        dataTypes.put("tinyint","int32_t");
        dataTypes.put("smallint","int32_t");
        dataTypes.put("mediumint","int32_t");
        dataTypes.put("int","int32_t");
        dataTypes.put("bigint","int64_t");
        dataTypes.put("float","float");
        dataTypes.put("double","double");
        dataTypes.put("real", "double");
        dataTypes.put("decimal","double");
        dataTypes.put("numeric", "double");
        dataTypes.put("bit","long"); //最大64 bits
        dataTypes.put("date","Date");
        dataTypes.put("time","Date");
        dataTypes.put("datetime","TimeStamp");
        dataTypes.put("timestamp","TimeStamp");
        dataTypes.put("year","Date");
        dataTypes.put("char","string");
        dataTypes.put("binary","byte[]");
        dataTypes.put("varchar","string");
        dataTypes.put("varbinary","byte[]");
        dataTypes.put("tinyblob","byte[]");
        dataTypes.put("tinytext","string");
        dataTypes.put("blob","byte[]");
        dataTypes.put("text","string");
        dataTypes.put("mediumblob","byte[]");
        dataTypes.put("mediumtext","string");
        dataTypes.put("longblob","byte[]");
        dataTypes.put("longtext","string");
        dataTypes.put("enum","Enum");// 最多65,535个
        dataTypes.put("set","Set"); // 最多64个
        List<Map<String, Object>> result = (List<Map<String, Object>>)columnDAO.getColumns("index_source_00");

        List<Map<String, Object>> fields = new ArrayList<>();
        List<Map<String, String>> index = new ArrayList<>();
        List<Map<String, String>> store = new ArrayList<>();

        List<String> multiValueFields = new ArrayList<>();


        for (Map<String, Object> column : result) {
            String schemaFieldType = dataTypes.get((String)column.get("DATA_TYPE"));
            String schemaFiledName = (String)column.get("COLUMN_NAME");
            String comment = (String)column.get("COLUMN_COMMENT");
            String columnKey = (String)column.get("COLUMN_KEY");

            boolean isUnique = false;

            if (columnKey.equals("UNI")) {
                isUnique = true;
            }

            boolean isMultiValued = false;

            if (comment.contains("json多值")) {
                isMultiValued = true;
                multiValueFields.add(schemaFiledName);
            }

        }

        return multiValueFields;
    }
}
