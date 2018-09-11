package xyz.yuzh.learn.spring.annotation.condition;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 16:33
 * <p>
 * 指定创建Bean的条件类
 */
public class WindowCondition implements Condition {
    private static final String CONDITION = "Windows";

    /**
     * 判断是否为window系统
     *
     * @param context               条件判断的上下文（环境）
     * @param annotatedTypeMetadata 注释信息
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 可以获取IOC使用的BeanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 可以获得类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 可以获得当前系统环境信息
        Environment environment = context.getEnvironment();
        // 可以获得bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        // 利用注册类判断是否包含指定的bean
        boolean contains = registry.containsBeanDefinition("rose");
        System.out.println("contains rose? "+contains);

        String osName = environment.getProperty("os.name");
        if (osName.contains(CONDITION)) return true;
        return false;
    }
}
