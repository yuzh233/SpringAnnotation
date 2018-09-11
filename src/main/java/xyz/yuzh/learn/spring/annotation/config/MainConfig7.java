package xyz.yuzh.learn.spring.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import xyz.yuzh.learn.spring.annotation.aop.LogAspect;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/11 17:56
 * <p>
 * AOP
 */
@EnableAspectJAutoProxy // 开启支持切面代理
@Configuration
@ComponentScan({"xyz.yuzh.learn.spring.annotation.aop"})
public class MainConfig7 {

    /**
     * 注册切面
     */
    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
