package xyz.yuzh.learn.demo.ssm.dao;

import java.util.Map;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/14 19:30
 * <p>
 * - @Insert(value = "insert into user(name,age) value(#{name}, #{age})") 语法的高级版
 * 可以动态的定制 sql
 * <p>
 * https://blog.csdn.net/qqlrq/article/details/45721755
 */
public class UserDaoProvider {

    public String selectByNameAndAge(Map<String, Object> para) {
        StringBuffer sql = new StringBuffer();
        sql.append("select * from user where ");
        sql.append("name = '" + para.get("name") + "'");
        sql.append(" and ");
        sql.append("age = '" + para.get("age") + "'");
        return sql.toString();
    }
}
