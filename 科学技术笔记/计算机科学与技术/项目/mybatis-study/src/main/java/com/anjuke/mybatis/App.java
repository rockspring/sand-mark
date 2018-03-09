package com.anjuke.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main( String[] args ) throws IOException{
        System.out.println( "Hello World!" );
        SqlSessionFactory sqlSessionFactory = null;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            Blog newBlog = new Blog();
            newBlog.setFlag(0);
            //session.insert()
            //int result = session.getMapper(BlogMapper.class).insertAndGetId();
            int result = session.insert("com.anjuke.mybatis.BlogMapper.insertAndGetId", newBlog);
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
