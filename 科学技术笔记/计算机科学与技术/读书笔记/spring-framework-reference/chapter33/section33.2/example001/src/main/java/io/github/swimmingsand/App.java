package io.github.swimmingsand;

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
        TaskExecutorExample taskExecutorExample = applicationContext.getBean(TaskExecutorExample.class);
        taskExecutorExample.printMessages();
    }
}
