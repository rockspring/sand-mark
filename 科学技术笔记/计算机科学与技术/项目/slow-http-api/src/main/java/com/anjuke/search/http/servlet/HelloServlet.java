package com.anjuke.search.http.servlet;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 9/2/16.
 */
@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(HelloServlet.class);

    final String greeting;

    public HelloServlet() {
        this("Hello");
    }

    public HelloServlet(String greeting) {
        this.greeting = greeting;
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {
        logger.trace("doGet start time:" + System.currentTimeMillis());

        String sleep = request.getParameter("sleep");
        long sleepTime = Long.parseLong(sleep);
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(
                "<h1>" + greeting + " from HelloServlet, you can call me sleep some ms</h1>");

        logger.trace("doGet end time:" + System.currentTimeMillis());
    }
}

