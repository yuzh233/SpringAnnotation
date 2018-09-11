package xyz.yuzh.learn.spring.annotation.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import xyz.yuzh.learn.spring.annotation.config.MainConfig4;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/11 11:50
 * <p>
 * 属性赋值测试
 */
public class Main4Test {
    private static AnnotationConfigApplicationContext context = null;

    static {
        context = new AnnotationConfigApplicationContext(MainConfig4.class);
    }

    @Test
    public void PropertyValues() {
        Object person = context.getBean("person");
        System.out.println(person);

        // 还可以通过环境对象获取值
        ConfigurableEnvironment environment = context.getEnvironment();
        environment.getPropertySources();
        String s = environment.getProperty("person.nikeName");
        System.out.println(s);
    }
}
