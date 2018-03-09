package io.github.swimmingsand.java7.chapter2.code2x8;

/**
 * Created by zlq on 7/1/15.
 */
public class Producer implements Runnable{

    private FileMock mock;
    private Buffer buffer;

    public Producer(FileMock mock, Buffer buffer) {
        this.mock = mock;
        this.buffer = buffer;
    }

    public void run() {
        buffer.setPendingLines(true);

        while (mock.hasMoreLines()) {
            String line = mock.getLine();
            buffer.insert(line);
        }

        buffer.setPendingLines(false);
    }
}
