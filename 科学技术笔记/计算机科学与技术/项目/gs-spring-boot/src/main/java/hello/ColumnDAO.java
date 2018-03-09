package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by zlq on 6/3/15.
 */
@Component
public class ColumnDAO extends JdbcDaoSupport {
    @Autowired
    public ColumnDAO(@Qualifier(value = "informationSchemaDataSource")DataSource zufangDataSource) {
        setDataSource(zufangDataSource);
    }

    public Object test() {
        String sql = "select * from columns where table_name='data_community'";

        Object result = this.getJdbcTemplate().queryForList(sql);

        return result;
    }

    public Object getColumns(String tableName) {
        String sql = "select * from columns where TABLE_SCHEMA= 'uesearch_db' and table_name=?";

        Object result = this.getJdbcTemplate().queryForList(sql, tableName);

        return result;
    }
}
