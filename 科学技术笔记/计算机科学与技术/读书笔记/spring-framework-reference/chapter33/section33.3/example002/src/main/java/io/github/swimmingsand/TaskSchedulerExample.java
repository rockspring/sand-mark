package io.github.swimmingsand;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;
import java.util.TimeZone;

/**
 * Created by zlq on 1/27/16.
 */
public class TaskSchedulerExample {
    private class MessagePrinterTask implements Runnable {
        private String message;

        public MessagePrinterTask(String message) {
            this.message = message;
        }

        public void run() {
            System.out.println(new Date() + " " + message);
        }
    }

    private TaskScheduler taskScheduler;

    public TaskSchedulerExample(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    public void printMessages() {
        //taskScheduler.scheduleAtFixedRate(new MessagePrinterTask("Message"), new Date(), 3000);
        //taskScheduler.scheduleWithFixedDelay(new MessagePrinterTask("Message"), new Date(), 3000);
        //taskScheduler.scheduleWithFixedDelay(new MessagePrinterTask("Message"), 3000);
        //taskScheduler.schedule(new MessagePrinterTask("Message"), new CronTrigger("10 2 11 * * *", TimeZone
                //.getTimeZone("GMT+08:00")));

        taskScheduler.schedule(new MessagePrinterTask("Message"), new CronTrigger("* * * * * *", TimeZone
                .getTimeZone("GMT+08:00")));
    }
}
