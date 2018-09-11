package xyz.yuzh.learn.spring.annotation.pojo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 23:09
 */
@Component
public class Cat {

    /**
     * 在bean创建完成并且属性赋值完成；来执行初始化方法
     */
    @PostConstruct
    public void init() {
        System.out.println("Cat[初始化]");
    }

    /**
     * 在容器销毁bean之前通知我们进行清理工作
     */
    @PreDestroy
    public void destroy() {
        System.out.println("Cat[销毁]");
    }
}
