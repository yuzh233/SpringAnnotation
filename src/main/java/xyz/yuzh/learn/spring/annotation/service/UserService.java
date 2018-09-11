package xyz.yuzh.learn.spring.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.yuzh.learn.spring.annotation.dao.UserDao;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/11 20:31
 */
@Service
/**Transactional 默认遇到 RuntimeException 异常时才会回滚，如果出现非 RuntimeException 异常会导致程序终止。
 * 可加上 rollbackFor="Exception" 处理所有异常包括错误*/
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class UserService {

    @Autowired
    private UserDao userDao;

    public void insert() {
        userDao.insert();
    }
}
