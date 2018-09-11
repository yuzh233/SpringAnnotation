package xyz.yuzh.learn.spring.annotation.dao;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 13:20
 */
@Repository
@Data
public class BookDao {
    private int level = 2;
}
