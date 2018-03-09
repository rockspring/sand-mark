package io.github.swimmingsand.java7.concurrentProgrammingDesign.code7;

/**
 * Created by zlq on 6/30/15.
 */
public class DBConnectionOK {

    private static DBConnectionOK connection;

    private DBConnectionOK() {
        System.out.printf("%s: Connection created.\n", Thread.currentThread().getName());
    }

    private static class LazyDBConnection {
        private static final DBConnectionOK INSTANCE = new DBConnectionOK();
    }

    public static DBConnectionOK getConnection() {
        return LazyDBConnection.INSTANCE;
    }
}
