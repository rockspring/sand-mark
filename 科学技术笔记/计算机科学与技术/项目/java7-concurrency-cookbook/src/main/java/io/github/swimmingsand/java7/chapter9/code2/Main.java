package io.github.swimmingsand.java7.chapter9.code2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 6/30/15.
 */
public class Main {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        FileSearch system = new FileSearch("/tmp/a", "log");
        FileSearch apps = new FileSearch("/tmp/b", "log");
        FileSearch documents = new FileSearch("/tmp/c", "log");

        Task systemTask = new Task(system, null);
        Task appTask = new Task(apps, null);
        Task documentsTask = new Task(documents, null);

        executor.submit(systemTask);
        executor.submit(appTask);
        executor.submit(documentsTask);

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.printf("Main: System Task: Number of Results:%d\n", systemTask.get().size());
            System.out.printf("Main: App Task: Number of Results:%d\n", appTask.get().size());
            System.out.printf("Main: Dcouments Task: Number of Results:%d\n", documentsTask.get().size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
