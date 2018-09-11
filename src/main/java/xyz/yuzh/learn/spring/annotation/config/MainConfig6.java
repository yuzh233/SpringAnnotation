package xyz.yuzh.learn.spring.annotation.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/11 15:51
 * <p>
 * - 自动装配（顺便复习获取配置文件属性值的三种方式）-
 * Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能；
 * 开发环境、测试环境、生产环境；
 * 数据源：(A)(B)(C)
 * <p>
 * - @Profile：指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件
 * 1. 加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中。默认是default环境
 * 2. 写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 * 3. 没有标注环境标识的bean在，任何环境下都是加载的；
 */
//@Profile("test")
@Configuration
@PropertySource(value = {"classpath:/dbconfig.properties"})
public class MainConfig6 implements EmbeddedValueResolverAware { // 属性值解析器

    @Value("${db.user}") // @Value 还可以添加到参数
    private String name;

    private String driverClass;

    /**
     * 测试环境的数据源
     */
    @Profile(value = {"default", "test"})
    @Bean
    public DataSource testDataSource(@Value("${db.password}") String password) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(name);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test_db");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    /**
     * 开发环境的数据源
     */
    @Profile(value = "dev")
    @Bean
    public DataSource devDataSource(@Value("${db.password}") String password) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(name);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dev_db");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    /**
     * 生产环境的数据源
     */
    @Profile(value = "prod")
    @Bean
    public DataSource prodDataSource(@Value("${db.password}") String password) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(name);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/prod_db");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.driverClass = stringValueResolver.resolveStringValue("${db.driverClass}");
    }
}
