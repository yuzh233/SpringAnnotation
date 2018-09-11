package xyz.yuzh.learn.spring.annotation.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 23:27
 * <p>
 * 后置处理器：初始化前后进行处理工作
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println(">初始化之前调用<");
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println(">销毁之前调用<");
        return o;
    }
}
