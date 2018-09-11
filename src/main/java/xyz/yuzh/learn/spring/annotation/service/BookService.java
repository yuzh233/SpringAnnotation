package xyz.yuzh.learn.spring.annotation.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import xyz.yuzh.learn.spring.annotation.dao.BookDao;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 13:20
 */
@Service
@Data
public class BookService {

    @Qualifier("bookDao1") // 指定注入手动装配的 bookDao1 ，不注入自动装配的 bookDao
    @Autowired(required = false) // 设置为false，当没有找到这个dao时不会报错。
    private BookDao bookDao;
}
