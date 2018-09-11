package xyz.yuzh.learn.spring.annotation.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.yuzh.learn.spring.annotation.config.MainConfig5;
import xyz.yuzh.learn.spring.annotation.service.BookService;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/11 14:09
 * <p>
 * 自动装配的测试
 */
public class Main5Test {
    private static AnnotationConfigApplicationContext context = null;

    static {
        context = new AnnotationConfigApplicationContext(MainConfig5.class);
    }

    @Test
    public void testAutowired() {
        BookService service = (BookService) context.getBean("bookService");
        System.out.println(service.getBookDao());
    }
}
