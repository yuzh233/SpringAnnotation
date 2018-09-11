package xyz.yuzh.learn.spring.annotation.pojo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 23:05
 * <p>
 * 实现接口控制bean的生命周期
 */
@Component
public class Dog implements InitializingBean, DisposableBean {

    /**
     * 定义初始化逻辑
     */
    public void afterPropertiesSet() throws Exception {
        System.out.println("Dog.afterPropertiesSet[创建]");
    }

    /**
     * 定义销毁逻辑
     */
    public void destroy() throws Exception {
        System.out.println("Dog.destroy[销毁]");
    }
}
