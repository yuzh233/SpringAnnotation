package xyz.yuzh.learn.spring.annotation.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.yuzh.learn.spring.annotation.config.MainConfig;
import xyz.yuzh.learn.spring.annotation.pojo.Person;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 12:42
 * <p>
 * 组件注册测试
 */
public class Main1Test {
    private static ApplicationContext context = null;

    static {
        context = new AnnotationConfigApplicationContext(MainConfig.class); // 配置类加载上下文
    }

    @Test
    public void testStartSpringAnnotationContext() {
        Person person = context.getBean(Person.class); // 通过类型查找，有多个同类型对象存在容器报错：NoUniqueBeanDefinitionException
        Person person1 = (Person) context.getBean("person"); // 通过id查找
        System.out.println(person);
        System.out.println(person1);
    }

    @Test
    public void testComponentScan() {
        String[] names = context.getBeanDefinitionNames(); // 容器中已存在的bean
        for (String name : names) {
            System.out.println(name);
        }
    }
}
