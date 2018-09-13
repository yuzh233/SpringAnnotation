package xyz.yuzh.learn.spring.annotation.webconfig;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/13 14:26
 * <p>
 * web配置类：web容器启动的时候创建对象；调用方法来初始化容器以下前端控制器
 */
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
        return new Class[]{WebConfig.class};
    }

    /**
     * 获取 DispatcherServlet 的映射信息（mvc的拦截路径）
     * <p>
     * - `/` 拦截所有请求（包括静态资源（xx.js,xx.png）），但是不包括*.jsp；
     * - `/*` 拦截所有请求；连*.jsp页面都拦截；jsp页面是tomcat的jsp引擎解析的；
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
