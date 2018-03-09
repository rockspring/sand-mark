package io.github.swimmingsand;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        BasicDataSource dataSource = (BasicDataSource)applicationContext.getBean("dataSource");
        String driverName = dataSource.getDriverClassName();
        System.out.println(driverName);
    }
}
