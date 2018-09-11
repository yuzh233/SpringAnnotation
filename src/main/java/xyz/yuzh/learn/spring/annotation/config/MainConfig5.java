package xyz.yuzh.learn.spring.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import xyz.yuzh.learn.spring.annotation.dao.BookDao;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/11 14:07
 * <p>
 * 自动装配
 *
 * 1. @Autowired
 *      - 默认优先按照类型去容器中找对应的组件: context.getBean(BookDao.class); 找到就赋值
 *      - 如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找 context.getBean("bookDao")
 *
 * 2. @Qualifier("bookDao")：指定需要装配的组件的id，而不是使用属性名。
 *      - 自动装配默认一定要将属性赋值好，没有就会报错；可以使用 @Autowired(required=false);
 *
 * 3. @Primary：让Spring进行自动装配的时候，默认使用首选的bean；注意：@Qualifier 优先级大于 @Primary.
 *
 * 4. @Resource:
 *      - 可以和 @Autowired 一样实现自动装配功能；默认是按照组件名称进行装配的；
 *      - 没有能支持 @Primary 功能，没有支持 @Autowired（reqiured=false）;
 *
 * 5. @Inject:
 *      - 需要导入javax.inject的包，和Autowired的功能一样。没有required=false的功能；
 *      - 区别：@Autowired:Spring定义的； @Resource、@Inject都是java规范
 *
 * 6. 自定义组件想要使用Spring容器底层的一些组件（ApplicationContext，BeanFactory，xxx）；
 *      可以实现xxxAware；在创建对象的时候，会调用接口规定的方法注入相关组件；Aware；
 * 		把Spring底层一些组件注入到自定义的Bean中；
 * 		xxxAware：功能使用xxxProcessor.
 * 			ApplicationContextAware -> ApplicationContextAwareProcessor；
 */
@Configuration
@ComponentScan(value = {"xyz.yuzh.learn.spring.annotation.controller", "xyz.yuzh.learn.spring.annotation.dao",
        "xyz.yuzh.learn.spring.annotation.service"})
public class MainConfig5 {

    @Bean(value = "bookDao1")
    @Primary // 当存在多个 BookDao 类型时，首选装配这个。
    public BookDao bookDao() {
        BookDao dao = new BookDao();
        dao.setLevel(1);
        return dao;
    }

}
