package xyz.yuzh.learn.spring.annotation.config;

import org.springframework.context.annotation.*;
import xyz.yuzh.learn.spring.annotation.condition.LinuxCondition;
import xyz.yuzh.learn.spring.annotation.condition.WindowCondition;
import xyz.yuzh.learn.spring.annotation.importselectors.MyImportBeanDefinitionRegistrar;
import xyz.yuzh.learn.spring.annotation.importselectors.MyImportSelector;
import xyz.yuzh.learn.spring.annotation.pojo.ColorFactoryBean;
import xyz.yuzh.learn.spring.annotation.pojo.Person;
import xyz.yuzh.learn.spring.annotation.pojo.Red;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 14:03
 * <p>
 * 组件注册
 */
@Configuration
@ComponentScan(value = "xyz.yuzh.learn.spring.annotation")
@Import(value = {Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

    /**
     * @Scope: 调整作用域
     * <p>
     * prototype：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。每次获取的时候才会调用方法创建对象；
     * singleton：单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。以后每次获取就是直接从容器（map.get()）中拿
     * request：同一次请求创建一个实例
     * session：同一个session创建一个实例
     * <p>
     * 懒加载：
     * 单实例bean：默认在容器启动的时候创建对象；
     * 懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化；
     */
//    @Scope(value = "prototype")
    @Lazy
    @Bean
    public Person rose() {
        System.out.println("rose is created.");
        return new Person("rose", 23);
    }

    @Conditional(value = {WindowCondition.class}) // 若注解在类上，则该类满足条件会创建全部的Bean。
    @Bean
    public Person bill() {
        return new Person("Bill Gates", 62);
    }

    @Conditional(value = {LinuxCondition.class})
    @Bean
    public Person linus() {
        return new Person("Linus", 48);
    }

    /**
     * 给容器中注册组件:
     * <p>
     * - 包扫描 + 组件标注注解 （@Controller/@Service/@Repository/@Component）[自己写的类]
     * - @Bean[ 导入的第三方包里面的组件 ]
     * - @Import[ 快速给容器中导入一个组件 ]
     * - @Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id 默认是全类名
     * - ImportSelector: 返回需要导入的组件的全类名数组；
     * - ImportBeanDefinitionRegistrar:手动注册bean到容器中
     * <p>
     * - 使用Spring提供的 FactoryBean（工厂Bean）;
     * - 默认获取到的是工厂bean调用getObject创建的对象
     * - 要获取工厂Bean本身，我们需要给id前面加一个 `&` -> &colorFactoryBean
     */
    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }

}

