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
public class CommunityDAO extends JdbcDaoSupport {

    @Autowired
    public CommunityDAO(@Qualifier(value = "communityDataSource")DataSource communityDataSource) {
        setDataSource(communityDataSource);
    }

    public Object findById(Integer id) {
        return super.getJdbcTemplate().queryForMap("select * from data_community where id=?", id);
    }
}
