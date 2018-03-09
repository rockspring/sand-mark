package io.bamboozhou;

import io.bamboozhou.component.CDplayer;
import io.bamboozhou.component.CompactDisc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@ImportResource({"classpath*:applicationContext.xml"})
public class SpringStudyApplication {
    public static void run1() {

    }

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(SpringStudyApplication.class, args);
		CompactDisc compactDisc = app.getBean(CompactDisc.class);
        String[] names = app.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        compactDisc.play();
        //compactDisc = (CompactDisc)app.getBean("sgtPeppers");
        compactDisc = (CompactDisc)app.getBean("lonelyHeartsClub");
		compactDisc.play();

        CDplayer cDplayer = app.getBean(CDplayer.class);
        cDplayer.play();
	}
}
