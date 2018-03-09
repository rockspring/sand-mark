package io.github.swimmingsand;

import org.springframework.scheduling.TaskScheduler;

import java.util.Date;

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
            System.out.println(message);
        }
    }

    private TaskScheduler taskScheduler;

    public TaskSchedulerExample(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    public void printMessages() {
        taskScheduler.schedule(new MessagePrinterTask("Message"), new Date());
    }
}
