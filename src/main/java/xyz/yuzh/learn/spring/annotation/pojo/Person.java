package xyz.yuzh.learn.spring.annotation.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 12:51
 *
 * 使用@Value赋值：
 * 	1. 基本数值
 * 	2. 可以写SpEL； #{}
 * 	3. 可以写${}；取出配置文件[properties]中的值（在运行环境变量里面的值），需要先导入配置文件
 */
@Data
public class Person {
    @Value("lisa")
    private String name;
    @Value("#{4*5}")
    private int age;
    @Value("${person.nikeName}")
    private String nikName;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
