package hello;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by zlq on 6/1/15.
 */
@Configuration
@ComponentScan
public class AppConfiguration {

    @Bean(name = "informationSchemaDataSource")
    @ConfigurationProperties(prefix = "spring.datasource_information_schema")
    public DataSource informationSchemaDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="dataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="zufangDataSource")
    @ConfigurationProperties(prefix="spring.datasource_zufang")
    public DataSource zufangDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="communityDataSource")
    @ConfigurationProperties(prefix="spring.datasource_community")
    public DataSource communityDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SolrServer solrServer(@Value("${solr.host}") String solrHost) {
        return new HttpSolrServer(solrHost);
    }
}
