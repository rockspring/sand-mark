import org.apache.log4j.Appender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 8/23/15.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Logger logger = Logger.getLogger(Main.class);
        Layout layout = new PatternLayout("%m%n");
        Appender appender = new DailyRollingFileAppender(layout,"a.txt",".YY-MM-dd.hh.mm");
        logger.addAppender(appender);
        logger.setLevel(Level.DEBUG);

        while (true) {
            logger.debug("log4j");
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
