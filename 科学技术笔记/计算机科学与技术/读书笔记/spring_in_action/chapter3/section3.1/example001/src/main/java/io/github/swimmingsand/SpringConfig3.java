package io.github.swimmingsand;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * Created by zlq on 2/16/16.
 */
public class SpringConfig3 {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:h2:tcp://dbserver/~/test");
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUsername("sa");
        dataSource.setPassword("password");
        dataSource.setInitialSize(20);
        dataSource.setMaxIdle(20);

        return dataSource;
    }
}
