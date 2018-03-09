package com.anjuke.search.http;

import com.anjuke.search.http.servlet.HelloServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

/**
 * Created by zlq on 9/2/16.
 */
public class SlowHttpServerMain {
    private static final Logger logger = LogManager.getLogger(SlowHttpServerMain.class);

    public static void printUsage() {
        String cmdPrefix = "java";
        String cmdSuffix = " -jar slow-http-api-server-jar-with-dependencies.jar";
        System.out.println(cmdPrefix + cmdSuffix + " [serverConfigPath]");
        System.exit(1);
    }

    public static void startJetty(String[] args) throws Exception {
        if (args.length != 1) {
            //printUsage();
        }

        logger.info("服务器启动,mainClass={}", SlowHttpServerMain.class.getCanonicalName());
        QueuedThreadPool threadPool = new QueuedThreadPool(4, 1);
        Server server = new Server(threadPool);
        server.setStopAtShutdown(true);
        server.setDumpAfterStart(true);

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        connector.setAcceptQueueSize(1);
        connector.setSoLingerTime(6000);
        server.setConnectors(new Connector[]{connector});

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(HelloServlet.class, "/hello");

        HandlerCollection handlers = new HandlerCollection();
        RequestLogHandler requestLogHandler = new RequestLogHandler();
        NCSARequestLog ncsaRequestLog = new NCSARequestLog("logs/request.yyyy_mm_dd.log");
        ncsaRequestLog.setRetainDays(7);
        ncsaRequestLog.setAppend(true);
        ncsaRequestLog.setExtended(false);
        ncsaRequestLog.setLogCookies(false);
        ncsaRequestLog.setLogTimeZone("Asia/Shanghai");
        ncsaRequestLog.setLogLatency(true);
        requestLogHandler.setRequestLog(ncsaRequestLog);
        //handlers.setHandlers(new Handler[] { context, new DefaultHandler(), requestLogHandler });
        handlers.setHandlers(new Handler[]{context, requestLogHandler});
        server.setHandler(handlers);

        server.start();
        server.join();
    }

    public static void main(String[] args) throws Exception {
        startJetty(args);
    }
}
