package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by zlq on 6/1/15.
 */
@Component
public class ZufangDAO extends JdbcDaoSupport{

    //private JdbcTemplate jdbcTemplate;

    //@Autowired
    //private DataSource zufangDataSource;

    @Autowired
    public ZufangDAO(@Qualifier(value = "zufangDataSource")DataSource zufangDataSource) {
        setDataSource(zufangDataSource);
    }

    public String getDataBaseName() throws Exception{
        return this.getJdbcTemplate().getDataSource().getConnection().getMetaData().getDatabaseProductName();
    }
}
