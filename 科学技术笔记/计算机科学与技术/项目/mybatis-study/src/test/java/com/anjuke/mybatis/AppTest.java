package com.anjuke.mybatis;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testScratch() {
        //DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
        DataSource dataSource = new PooledDataSource("com.mysql.jdbc.Driver","jdbc:mysql://127.0.0.1:3306/test", "root", "admin");
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession session = sqlSessionFactory.openSession();
        Blog blog = session.selectOne("com.anjuke.mybatis.BlogMapper.selectBlog", 101);
        System.out.println(blog.getId());
    }

    @Test
    public void testScratch2() {
        //DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
        DataSource dataSource = new PooledDataSource("com.mysql.jdbc.Driver","jdbc:mysql://127.0.0.1:3306/test", "root", "admin");
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = mapper.selectBlog(1);
            System.out.println(blog.getId());
        } finally {
            session.close();
        }

    }

    @Test
    public void testScratch3() throws IOException {
        SqlSessionFactory sqlSessionFactory = null;
        String resource = "mybatis-config-1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        Properties properties = new Properties();
        //properties.setProperty("username", "root1");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            Blog newBlog = new Blog();
            newBlog.setFlag(0);
            //session.insert()
            //int result = session.getMapper(BlogMapper.class).insertAndGetId();
            //int result = session.insert("com.anjuke.mybatis.BlogMapper.insertAndGetId", newBlog);
            System.out.println(newBlog.getId());
            Blog blog = session.selectOne("com.anjuke.mybatis.BlogMapper.selectBlog", newBlog.getId());

            if (null != blog) {
                System.out.println(blog.getId());
            }

        } finally {
            session.close();
        }
    }
}
