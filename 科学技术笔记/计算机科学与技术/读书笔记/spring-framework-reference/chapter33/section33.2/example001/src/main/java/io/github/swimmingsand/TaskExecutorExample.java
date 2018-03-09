package io.github.swimmingsand;

import org.springframework.core.task.TaskExecutor;

/**
 * Created by zlq on 1/26/16.
 */
public class TaskExecutorExample {

    private class MessagePrinterTask implements Runnable {
        private String message;

        public MessagePrinterTask(String message) {
            this.message = message;
        }

        public void run() {
            System.out.println(message);
        }
    }

    private TaskExecutor taskExecutor;

    public TaskExecutorExample(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void printMessages() {
        for (int i = 0; i < 25; ++i) {
            taskExecutor.execute(new MessagePrinterTask("Message" + i));
        }
    }
}
