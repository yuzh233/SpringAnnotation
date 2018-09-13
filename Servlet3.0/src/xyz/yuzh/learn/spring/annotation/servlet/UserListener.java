package xyz.yuzh.learn.spring.annotation.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/13 10:51
 */
public class UserListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("[UserListener.initialized]");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("[UserListener.destroyed]");
    }
}
