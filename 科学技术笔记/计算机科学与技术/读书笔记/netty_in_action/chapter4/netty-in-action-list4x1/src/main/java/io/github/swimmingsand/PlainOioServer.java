package io.github.swimmingsand;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Hello world!
 *
 */
public class PlainOioServer {
    public void serve(int port) throws IOException {
        final ServerSocket socket = new ServerSocket(port);
        try {
            for (;;) {
                final Socket clientSocket = socket.accept();
                System.out.println("Accepted Connection from " + clientSocket);
                new Thread(new Runnable() {
                    public void run() {
                        OutputStream out;
                        try {
                            out = clientSocket.getOutputStream();
                            out.write("Hi\r\n".getBytes(Charset.forName("UTF-8")));
                            out.flush();
                            //clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        /**try {
                            clientSocket.close();
                        } catch (IOException ex) {

                        }**/
                    }
                }).run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main( String[] args ) throws IOException{
        PlainOioServer plainOioServer = new PlainOioServer();
        plainOioServer.serve(8080);
    }
}
