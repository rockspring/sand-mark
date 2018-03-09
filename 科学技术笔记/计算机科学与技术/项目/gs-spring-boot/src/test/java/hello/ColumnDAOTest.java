package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zlq on 6/3/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MockServletContext.class, Application.class})
@WebAppConfiguration
@Component
public class ColumnDAOTest {
    @Autowired
    private ColumnDAO columnDAO;

    @Test
    public void testIndexSourceSchema() {
        Map<String, String> dataTypes = new HashMap<>();
        dataTypes.put("tinyint","int32_t");
        dataTypes.put("smallint","int32_t");
        dataTypes.put("mediumint","int32_t");
        dataTypes.put("int","int32_t");
        dataTypes.put("bigint","uint64_t");
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
        List<Map<String, Object>> result = (List<Map<String, Object>>)columnDAO.getColumns("index_source00");

        List<Map<String, Object>> fields = new ArrayList<>();
        List<Map<String, String>> index = new ArrayList<>();
        List<Map<String, String>> store = new ArrayList<>();

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

            if (isMultiValued) {
                field.put("multi_value", true);
            }

            if (isUnique) {
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
    }
}
