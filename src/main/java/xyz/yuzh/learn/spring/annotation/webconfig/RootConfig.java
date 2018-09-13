package xyz.yuzh.learn.spring.annotation.webconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/13 14:20
 * <p>
 * 根容器：配置事务、数据源、配置文件相关，在config包中。
 */
@ComponentScan(value = {"xyz.yuzh.learn.spring.annotation"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)
})
public class RootConfig {

}
