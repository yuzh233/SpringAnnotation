package xyz.yuzh.learn.spring.annotation.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.yuzh.learn.spring.annotation.aop.MathCalculator;
import xyz.yuzh.learn.spring.annotation.config.MainConfig7;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/11 17:57
 * <p>
 * AOP test
 */
public class Main7Test {
    private static AnnotationConfigApplicationContext context = null;

    static {
        context = new AnnotationConfigApplicationContext(MainConfig7.class);
    }

    @Test
    public void testAspect() {
        MathCalculator calculator = context.getBean(MathCalculator.class);
        calculator.div(1, 1);
    }
}
