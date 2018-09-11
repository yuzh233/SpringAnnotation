package xyz.yuzh.learn.spring.annotation.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import xyz.yuzh.learn.spring.annotation.service.BookService;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 13:19
 */
@Controller
@Data
public class BookController {
    @Autowired
    private BookService bookService;
}
