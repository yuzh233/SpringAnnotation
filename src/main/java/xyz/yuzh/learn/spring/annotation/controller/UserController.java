package xyz.yuzh.learn.spring.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.yuzh.learn.spring.annotation.service.UserService;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/13 14:37
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/welcome")
    public String hi() {
        return userService.sayHi("world!");
    }

    // @ResponseBody
    @RequestMapping("/insert")
    public String success() {
        userService.insert();
        return "success";
    }
}
