package xyz.yuzh.learn.spring.annotation.webconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;
import xyz.yuzh.learn.spring.annotation.intercepter.MyIntercepter;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/13 14:20
 * <p>
 * WebMvc容器
 */
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
     * 开启静态资源访问 相当于 <mvc:default-servlet-controller>
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
