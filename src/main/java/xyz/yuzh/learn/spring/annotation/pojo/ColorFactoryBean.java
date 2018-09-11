package xyz.yuzh.learn.spring.annotation.pojo;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 17:42
 * <p>
 * 工厂方式创建bean
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean.getObject()..");
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    //是单例？
    //true：这个bean是单实例，在容器中保存一份
    //false：多实例，每次获取都会创建一个新的bean；
    public boolean isSingleton() {
        return true;
    }
}
