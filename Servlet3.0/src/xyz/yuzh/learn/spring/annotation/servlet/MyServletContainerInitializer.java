package xyz.yuzh.learn.spring.annotation.servlet;

import xyz.yuzh.learn.spring.annotation.servlet.service.HelloService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/13 9:17
 * <p>容器在启动应用的时候，会扫描当前应用每一个 jar 包里面 `META-INF/services/javax.servlet.ServletContainerInitializer`
 * 路径下指定的实现类，启动并运行这个实现类的方法，以达到容器启动运行相关类的目的。</p>
 * <p>
 * - 自定义的 Servlet / Filter / Listener 可以在相应的类上使用 @WebServlet / @WebFilter / @WebListener
 * - 当需要引入第三方组件时，可以使用编码的方式，在项目启动的时候给 ServletContext 里面添加组件：
 * - 1. 利用初始化器中的 ServletContext 给容器添加组件
 * - 2. 自定义一个监听器，在容器启动时通过 ServletContextListener 得到 ServletContext 给容器添加组件 </p>
 * <p>
 * 组件只能在容器启动时添加，运行过程中不能添加 </p>
 */
@HandlesTypes({HelloService.class}) // 容器启动的时候会将 @HandlesTypes 指定的这个类型下面的子类（实现类，子接口等）传递过来
public class MyServletContainerInitializer implements ServletContainerInitializer {

    /**
     * 容器启动时会运行该方法
     *
     * @param set            所有感兴趣的类型的子类集合
     * @param servletContext 一个 Web 应用一个 ServletContext 上下文
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        // 查看所有子类型
        Iterator<Class<?>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Class<?> aClass = iterator.next();
            System.out.println(aClass);
        }
        System.out.println("ServletContext: " + servletContext);

        /* 编码方式添加组件 */

        // 监听器
        servletContext.addListener(UserListener.class);

        // Servlet
        ServletRegistration.Dynamic servlet = servletContext.addServlet("userServlet", new UserServlet()); // servletName, class
        servlet.addMapping("/user"); // 配置映射信息

        // Filter
        FilterRegistration.Dynamic filter = servletContext.addFilter("userFilter", UserFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }
}
