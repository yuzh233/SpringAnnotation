package xyz.yuzh.learn.demo.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.yuzh.learn.demo.ssm.dao.UserDao;
import xyz.yuzh.learn.demo.ssm.mepper.User;

import java.util.List;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/14 19:13
 */
@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/insert")
    public void insert() {
        User user = new User();
        user.setName("lisa");
        user.setAge(24);
        userDao.insert(user);
    }

    @RequestMapping("/update")
    public void update(int id) {
        User user = new User();
        user.setId(id);
        user.setName("lisa");
        user.setAge(26);
        userDao.update(user);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        System.out.println(id);
        userDao.delete(id);
    }

    @ResponseBody
    @RequestMapping("/findAll")
    public List<User> findAll() {
        List<User> users = userDao.selectAll();
        return users;
    }

    @ResponseBody
    @RequestMapping("/selectByNameAndAge/{name}/{age}")
    public List<User> selectByNameAndAge(@PathVariable String name, @PathVariable int age) {
        System.out.println(name);
        System.out.println(age);
        List<User> users = userDao.selectByNameAndAge(name, age);
        return users;
    }
}
