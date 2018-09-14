package xyz.yuzh.learn.demo.ssm.dao;

import org.apache.ibatis.annotations.*;
import xyz.yuzh.learn.demo.ssm.mepper.User;

import java.util.List;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/14 19:13
 */
public interface UserDao {

    @Insert(value = "insert into user(name,age) value(#{name}, #{age})")
    int insert(User user);

    @Update(value = "update user set name = #{name}, age = #{age} where id = #{id}")
    void update(User user);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select(value = "select id, name, age from user where id = #{id}")
    User select(int id);


    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select(value = "select id, name, age from user")
    List<User> selectAll();

    @Delete(value = "delete from user where id = #{id} ")
    int delete(int id);

    @SelectProvider(type = UserDaoProvider.class, method = "selectByNameAndAge")
    List<User> selectByNameAndAge(@Param("name") String name, @Param("age") int age);
}
