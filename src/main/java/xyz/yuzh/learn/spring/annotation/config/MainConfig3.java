package xyz.yuzh.learn.spring.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import xyz.yuzh.learn.spring.annotation.pojo.Car;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 22:49
 * <p>
 * bean 的生命周期（bean创建---初始化----销毁的过程）
 * <p>
 * 构造（对象创建）
 * - 单实例：在容器启动的时候创建对象
 * - 多实例：在每次获取的时候创建对象
 * <p>
 * 销毁：
 * - 单实例：容器关闭的时候调用销毁方法
 * - 多实例：容器不会管理这个bean；容器不会调用销毁方法；
 * <p>
 * 指定初始化和销毁方法：
 * 1. 通过 @Bean 指定 init-method 和 destroy-method
 * 2. 通过让Bean实现 InitializingBean（定义初始化逻辑），DisposableBean（定义销毁逻辑）
 * 3. 使用JSR250：
 * - @PostConstruct： 在bean创建完成并且属性赋值完成；来执行初始化方法
 * - @PreDestroy： 在容器销毁bean之前通知我们进行清理工作
 * 4. BeanPostProcessor<interface>：bean的后置处理器（不管是否指定初始化和销毁方法都会调用）
 * - BeanPostProcessor.postProcessBeforeInitialization -> bean的初始化方法调用之前工作
 * - BeanPostProcessor.postProcessAfterInitialization -> bean的销毁方法调用之前工作
 */
@Configuration
@ComponentScan(value = "xyz.yuzh.learn.spring.annotation.pojo")
public class MainConfig3 {

    @Scope("singleton")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }

}
