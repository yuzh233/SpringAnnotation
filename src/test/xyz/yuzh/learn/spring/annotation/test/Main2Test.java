package xyz.yuzh.learn.spring.annotation.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.yuzh.learn.spring.annotation.config.MainConfig;
import xyz.yuzh.learn.spring.annotation.config.MainConfig2;
import xyz.yuzh.learn.spring.annotation.pojo.Color;
import xyz.yuzh.learn.spring.annotation.pojo.Person;

import java.util.Arrays;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 12:42
 * <p>
 * 组件注册测试
 */
public class Main2Test {
    private static ApplicationContext context = null;

    static {
        context = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("- The IOC container has been activated.- ");
    }

    @Test
    public void testBeanScope() {
        Person person = context.getBean(Person.class);
        Person person2 = (Person) context.getBean("rose");
        System.out.println(person);
        System.out.println(person2);
        System.out.println(person == person2); // 单实例两个对象是一致的，多实例是不一致的。
    }

    @Test
    public void testCondition() {
        String[] names = context.getBeanNamesForType(Person.class);
        System.out.println(Arrays.toString(names));

        for (String beanName : names) {
            System.out.println(context.getBean(beanName));
        }
    }

    @Test
    public void testImport() {
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void testFactoryBean() {
        Object color = context.getBean("&colorFactoryBean");
        System.out.println(color);
    }
}
