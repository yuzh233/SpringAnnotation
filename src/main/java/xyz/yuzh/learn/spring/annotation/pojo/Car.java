package xyz.yuzh.learn.spring.annotation.pojo;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 22:57
 */
public class Car {

    public Car(){
        System.out.println("Car[构造器]");
    }

    public void init(){
        System.out.println("Car[初始化]");
    }

    public void destroy(){
        System.out.println("Car[销毁]");
    }
}
