package xyz.yuzh.learn.spring.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import xyz.yuzh.learn.spring.annotation.pojo.Person;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/11 11:47
 * <p>
 * 属性赋值
 */
@Configuration
@PropertySource(value = {"classpath:/person.properties"}) // 导入配置文件
public class MainConfig4 {

    @Bean
    public Person person(){
        return new Person();
    }
}
