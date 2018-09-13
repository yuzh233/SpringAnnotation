> https://docs.spring.io/spring/docs/5.0.9.RELEASE/spring-framework-reference/web.html

<!-- TOC -->

- [组件注册](#组件注册)
- [生命周期](#生命周期)
- [属性赋值](#属性赋值)
- [自动装配](#自动装配)
- [AOP](#aop)
- [事务](#事务)
- [Servlet](#servlet)
- [SpringMVC](#springmvc)
    - [Web 配置类](#web-配置类)
    - [SpringMVC 配置类](#springmvc-配置类)
- [异步处理](#异步处理)
    - [Servlet 3.0 异步处理](#servlet-30-异步处理)
    - [SpringMVC 异步处理](#springmvc-异步处理)

<!-- /TOC -->

## 组件注册

- [@Configuration](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig.java)
- [@ComponentScan](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig.java)
- [@Bean](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig.java)
- [@Scope](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig2.java)
- [@Lazy](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig2.java)
- [@Conditional](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig2.java)
- [@Import](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig2.java)

## 生命周期

- [@Bean 指定初始化和销毁方法](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig3.java)
- [实现 InitializingBean和DisposableBean 指定初始化和销毁方法](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/pojo/Dog.java)
- [@PostConstruct / @PreDestroy 指定初始化和销毁方法](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/pojo/Cat.java)

## 属性赋值

- [@Value 赋值](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/pojo/Person.java)
- [@PropertySource 加载外部配置文件](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/pojo/Person.java)

## 自动装配

- [@Autowired / @Qualifier / @Primary](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig5.java)
- [@Resource / @Inject](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig5.java)
- [实现 Aware 注入 Spring 底层组件](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/pojo/Red.java)
- [@Profile 环境搭建](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig6.java)
- [@Profile 环境激活](https://github.com/yuzh233/SpringAnnotation/blob/master/src/test/xyz/yuzh/learn/spring/annotation/test/Main6Test.java)

## AOP

- [@Aspect / @Pointcut / @Before / @After / @AfterReturning / @AfterThrowing / @Around ](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/aop/LogAspect.java)
- [@EnableAspectJAutoProxy](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig7.java)

## 事务

- [@Transactional](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/service/UserService.java)
- [@EnableTransactionManagement](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig8.java)
- [DataSource / Template / PlatformTransactionManager](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig8.java)

## Servlet
- [自定义组件 @WebServlet / @WebFilter / @WebListener ](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/servlet/HelloServlet.java)

- [ServletContainerInitializer 初始化器](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/servlet/MyServletContainerInitializer.java)

- [利用 ServletContainerInitializer.ServletContext / ServletContextListener.ServletContext 添加第三方组件](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/servlet/MyServletContainerInitializer.java)

## SpringMVC
### Web 配置类
组件加载流程：

1. 导入 webmvc 包后，lib 中多了一个 `spring-web-4.3.12.RELEASE.jar` 

2. web容器在启动的时候，会扫描每个jar包下的 META-INF/services/javax.servlet.ServletContainerInitializer 。此时在 `spring-web-4.3.12.RELEASE.jar` 包中扫描到了该文件：

    ![Alt text](/spring_img/1.jpg)

3. 加载文件中指定的类： `org.springframework.web.SpringServletContainerInitializer` 

    ![Alt text](/spring_img/2.jpg)

4. SpringServletContainerInitializer 会加载 WebApplicationInitializer 接口下所有的组件。并且为 WebApplicationInitializer 组件创建对象（当组件不是接口，不是抽象类时）


我们的 `web配置类` 要继承的类： `AbstractAnnotationConfigDispatcherServletInitializer` 是 WebApplicationInitializer 接口的间接子类。
```java
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 加载根容器的配置类：Spring配置
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * 加载webmvc容器的配置类：SpringMVC 配置
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    /**
     * 获取 DispatcherServlet 的映射信息
     * <p>
     * - `/` 拦截所有请求（包括静态资源（xx.js,xx.png）），但是不包括*.jsp；
     * - `/*` 拦截所有请求；连*.jsp页面都拦截；jsp页面是tomcat的jsp引擎解析的；
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
```

### SpringMVC 配置类
```java
@ComponentScan(value = {"xyz.yuzh.learn.spring.annotation"}, includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)
}, useDefaultFilters = false)
@EnableWebMvc // 开启 SpringMVC 定制配置功能，等同于 <mvc:annotation-driven/>
public class WebConfig extends WebMvcConfigurerAdapter { // WebMvcConfigurerAdapter抽象类 实现了 WebMvcConfigurer 接口来定制MVC的所有配置，实现抽象类使得我们不必重写所有所有接口方法

    /**
     * 定制视图解析器
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp"); // 若不加参数默认为：("/WEB-INF/",".jsp")
    }

    /**
     * 开启静态资源访问 相当于 <mvc:default-servlet-handler>
     *     springMVC 默认拦截所有的请求包括静态资源，解除静态资源访问限制，但仅对WEB根目录下文件有效，如果文件在WEB-INF解除无效。
     */
    /*@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }*/

    /**
     * 定制拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyIntercepter()).addPathPatterns("/**"); // 拦截所有目录及文件
    }

    /**
     * 这种方式访问 WEB-INF 下的静态资源 <mvc:resources location="/WEB-INF/resources/" mapping="/resources/**"/>
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
    }
}
```

更多配置查阅 [文档](https://docs.spring.io/spring/docs/5.0.9.RELEASE/spring-framework-reference/web.html#mvc-config-static-resources)

## 异步处理
### Servlet 3.0 异步处理
在Servlet 3.0之前，Servlet采用Thread-Per-Request的方式处理请求。即每一次Http请求都由某一个线程从头到尾负责处理。

如果一个请求需要进行IO操作，比如访问数据库、调用第三方服务接口等，那么其所对应的线程将同步地等待IO操作完成， 而IO操作是非常慢的，所以此时的线程并不能及时地释放回线程池以供后续使用，在并发量越来越大的情况下，当线程池已满，许多请求不能及时的被处理。这将带来严重的性能问题。

即便是像Spring、Struts这样的高层框架也脱离不了这样的桎梏，因为他们都是建立在Servlet之上的。为了解决这样的问题，Servlet 3.0引入了异步处理，然后在Servlet 3.1中又引入了非阻塞IO来进一步增强异步处理的性能。
```java
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
```

### SpringMVC 异步处理
