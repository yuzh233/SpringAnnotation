package xyz.yuzh.learn.spring.annotation.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.yuzh.learn.spring.annotation.config.MainConfig3;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 22:59
 * <p>
 * 生命周期测试
 */
public class Main3Test {
    private static AnnotationConfigApplicationContext context = null;

    static {
        context = new AnnotationConfigApplicationContext(MainConfig3.class);
    }

    @Test
    public void testLifeCycle() {
        context.close();
    }
}
