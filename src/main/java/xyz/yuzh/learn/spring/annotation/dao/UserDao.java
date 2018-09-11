package xyz.yuzh.learn.spring.annotation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/11 20:29
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert() {
        String sql = "INSERT USER (NAME ,age ) VALUE(?,?)";
        String name = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql, new Object[]{name, 18});
        // int i = 1 / 0;
    }
}
