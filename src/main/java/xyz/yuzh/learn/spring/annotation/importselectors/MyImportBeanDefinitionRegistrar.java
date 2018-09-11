package xyz.yuzh.learn.spring.annotation.importselectors;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import xyz.yuzh.learn.spring.annotation.pojo.Rainbow;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 17:22
 * <p>
 * 手动注册 bean 到容器
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * 把所有需要添加到容器中的bean，手工注册到容器。注册之前，进行一些条件判断
     *
     * @param annotationMetadata 当前类的注解信息
     * @param registry           bean定义的注册类
     */
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        boolean condition = registry.containsBeanDefinition("xyz.yuzh.learn.spring.annotation.pojo.Red");
        boolean condition2 = registry.containsBeanDefinition("xyz.yuzh.learn.spring.annotation.pojo.Blue");
        if (condition && condition2) {
            // 指定 bean 的定义信息
            RootBeanDefinition definition = new RootBeanDefinition(Rainbow.class);
            // 手动注册一个 bean 到容器
            registry.registerBeanDefinition("rainBow", definition);
        }
    }
}
