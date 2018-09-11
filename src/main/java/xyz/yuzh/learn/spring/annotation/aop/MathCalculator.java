package xyz.yuzh.learn.spring.annotation.aop;

import org.springframework.stereotype.Component;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/11 17:31
 */
@Component
public class MathCalculator {

    public int div(int i, int j) {
        System.out.println("execution div..");
        // int n = 1 / 0;
        return i / j;
    }

}
