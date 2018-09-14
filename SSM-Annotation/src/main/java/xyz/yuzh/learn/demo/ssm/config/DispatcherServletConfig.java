package xyz.yuzh.learn.demo.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/14 18:45
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = {"xyz.yuzh.learn.demo.ssm"}, includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)
}, useDefaultFilters = false)
public class DispatcherServletConfig extends WebMvcConfigurerAdapter {

    /**
     * 定制视图解析器
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp"); // 若不加参数默认为：("/WEB-INF/",".jsp")
    }

    /**
     * 这种方式访问 WEB-INF 下的静态资源 <mvc:resources location="/WEB-INF/resources/" mapping="/resources/**"/>
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
    }

}
