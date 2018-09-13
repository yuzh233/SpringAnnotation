package xyz.yuzh.learn.spring.annotation.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/13 16:59
 */
@WebServlet(value = "/async", asyncSupported = true) // 支持异步处理asyncSupported=true
public class HelloAsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 开启异步模式
        System.out.println("主线程开始。。。" + Thread.currentThread() + "->" + System.currentTimeMillis());
        AsyncContext startAsync = req.startAsync();

        //业务逻辑进行异步处理; 开始异步处理
        startAsync.start(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("副线程开始 " + Thread.currentThread() + "->" + System.currentTimeMillis());
                    sayHello();
                    startAsync.complete(); // 异步处理完
                    AsyncContext asyncContext = req.getAsyncContext(); // 获取到异步上下文
                    ServletResponse response = asyncContext.getResponse(); // 获取响应
                    response.getWriter().write("hello async...");
                    System.out.println("副线程结束 " + Thread.currentThread() + "->" + System.currentTimeMillis());
                } catch (Exception e) {
                }
            }
        });
        System.out.println("主线程结束。。。" + Thread.currentThread() + "->" + System.currentTimeMillis());
    }

    public void sayHello() throws Exception {
        System.out.println(Thread.currentThread() + " processing...");
        Thread.sleep(3000);
    }
}
