package xyz.yuzh.learn.spring.annotation.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/11 20:13
 * <p>
 * 声明式事务：
 * <p>
 * 环境搭建：
 * 1. 导入相关依赖：数据源、数据库驱动、Spring-jdbc模块
 * 2. 配置数据源、JdbcTemplate
 * 3. 给方法上标注 @Transactional 表示当前方法是一个事务方法；
 * 4. @EnableTransactionManagement 开启基于注解的事务管理功能；
 * 5. 配置事务管理器来控制事务：
 * - @Bean public PlatformTransactionManager transactionManager()
 */
@EnableTransactionManagement
@Configuration
@PropertySource({"classpath:/dbconfig.properties"})
@ComponentScan({"xyz.yuzh.learn.spring.annotation.service", "xyz.yuzh.learn.spring.annotation.dao"})
public class MainConfig8 {

    @Value("${db.user}")
    private String user;

    @Value("${db.password}")
    private String password;

    @Value("${db.driverClass}")
    private String driverClass;

    @Value("${db.jdbcUrl}")
    private String jdbcUrl;

    /**
     * 配置数据源
     */
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    /**
     * 配置 JdbcTemplate
     */
    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        //Spring对@Configuration类会特殊处理；给容器中加组件的方法，多次调用都只是从容器中找组件
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    /**
     * 注册事务管理器
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
