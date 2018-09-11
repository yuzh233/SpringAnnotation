package xyz.yuzh.learn.spring.annotation.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.yuzh.learn.spring.annotation.config.MainConfig8;
import xyz.yuzh.learn.spring.annotation.service.UserService;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/11 20:33
 * <p>
 * Transaction test
 */
public class Main8Test {
    private static AnnotationConfigApplicationContext context = null;

    static {
        context = new AnnotationConfigApplicationContext(MainConfig8.class);
    }

    @Test
    public void testTransaction() {
        UserService userService = context.getBean(UserService.class);
        userService.insert();
    }
}
