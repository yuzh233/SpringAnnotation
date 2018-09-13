package xyz.yuzh.learn.spring.annotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/13 20:17
 */
@Controller
public class AsyncController {
    /**
     * 异步处理
     * 1. 控制器返回 Callable
     * 2. Spring 异步处理，将Callable 提交到 TaskExecutor 使用一个隔离的线程进行执行
     * 3. DispatcherServlet 和所有的 Filter 退出 web 容器的线程，但是 response 保持打开状态；
     * 4. Callable 返回结果，Spring MVC 将请求重新派发给容器，恢复之前的处理；
     * 5. 根据 Callable 返回的结果。Spring MVC 继续进行视图渲染流程等（从收请求-视图渲染）。
     */
    @ResponseBody
    @RequestMapping("/async01")
    public Callable<String> async01() {
        System.out.println("主线程开始." + Thread.currentThread() + "->" + System.currentTimeMillis());

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("副线程开始." + Thread.currentThread() + "->" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("副线程开始." + Thread.currentThread() + "->" + System.currentTimeMillis());
                return "Callable<String> async01()";
            }
        };

        System.out.println("主线程结束." + Thread.currentThread() + "->" + System.currentTimeMillis());
        return callable;
    }


    /**************************************************
     *                 DeferredResult
     **************************************************/

    /**
     * 处理请求：创建订单
     * - 1. 构建 DeferredResult 对象，设置超时事件，失败提示
     * - 2. 通过 JMS 发送一个 DeferredResultQueue 对象的消息，该对象存储 DeferredResult.
     * - 3. 若接收端在限定时间内给 DeferredResult 存入了结果，则返回 DeferredResult 的结果，否则结果是失败提示。
     */
    @ResponseBody
    @RequestMapping("/createOrder")
    public DeferredResult<Object> createOrder() {
        DeferredResult<Object> deferredResult = new DeferredResult<>((long) 3000, "create fail...");
        // 模拟发送消息：把结果对象存入一个队列中，假设 DeferredResultQueue 队列就是消息通知内容
        DeferredResultQueue.save(deferredResult);
        // 等待异步存入结果到 deferredResult 中并返回，超时则失败
        return deferredResult;
    }


    /**
     * 模拟异步的存入请求结果：执行创建
     * - 1. 监听 JMS 消息，获得消息内容（DeferredResultQueue对象）
     * - 2. 从消息对象 DeferredResultQueue 中拿到 DeferredResult 延迟异步结果对象。
     * - 3. 执行业务逻辑，赋值。
     */
    @ResponseBody
    @RequestMapping("/create")
    public String create() {
        //创建订单
        String order = UUID.randomUUID().toString();
        // 获取到消息通知，从中获取到需要存取结果的对象
        DeferredResult<Object> deferredResult = DeferredResultQueue.get();
        // 向结果对象存入值，请求返回结果
        deferredResult.setResult(order);
        return "success: " + order;
    }
}

class DeferredResultQueue {
    private static ConcurrentLinkedQueue<DeferredResult<Object>> queue = new ConcurrentLinkedQueue<DeferredResult<Object>>();

    public static void save(DeferredResult<Object> deferredResult) {
        queue.add(deferredResult);
    }

    public static DeferredResult<Object> get() {
        return queue.poll();
    }
}