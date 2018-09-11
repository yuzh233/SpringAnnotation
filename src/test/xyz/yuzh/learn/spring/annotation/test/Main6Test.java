package xyz.yuzh.learn.spring.annotation.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.yuzh.learn.spring.annotation.config.MainConfig6;

import javax.sql.DataSource;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/11 16:15
 * <p>
 * - @Profile 注解激活的测试
 * 1. 使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test（IDEA:Run->EditConfigurations->VM options:）
 * 2. 代码的方式激活某种环境
 */
public class Main6Test {
    private static AnnotationConfigApplicationContext context;

    static {
        context = new AnnotationConfigApplicationContext();
    }

    @Test
    public void testProfile() {
        // 设置激活的环境（不指定环境通过虚拟机参数获取环境）
        context.getEnvironment().setActiveProfiles("prod");
        // 注册主配置类
        context.register(MainConfig6.class);
        // 刷新Context
        context.refresh();

        String[] namesForType = context.getBeanNamesForType(DataSource.class);
        for (String string : namesForType) {
            System.out.println(string);
        }
    }

}
