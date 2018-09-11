package xyz.yuzh.learn.spring.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import xyz.yuzh.learn.spring.annotation.pojo.Person;
import xyz.yuzh.learn.spring.annotation.scanfilter.MyTypeFilter;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 12:41
 * <p>
 * 组件注册
 */
@Configuration // 声明配置类

// 注解扫描
/*@ComponentScan(value = "xyz.yuzh.learn.spring.annotation", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Repository.class, Service.class})
})*/
@ComponentScan(value = "xyz.yuzh.learn.spring.annotation", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}), // 以注解类型作为拦截过滤器，拦截对应注解的Bean。
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {Person.class}), // 以指定类型作为拦截过滤器
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class}) // 以自定义规则拦截
}, useDefaultFilters = false) // 不使用默认拦截规则，才能是自己的规则生效。

public class MainConfig {

    @Bean(value = "person") // 注册一个Bean，new 构造一个对象；默认以方法名为id，也可通过value属性值指定id；构造器参数为依赖注入；
    public Person person01() {
        return new Person("lisa", 22);
    }

}
