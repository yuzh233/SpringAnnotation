import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.yuzh.learn.demo.ssm.config.RootConfig;
import xyz.yuzh.learn.demo.ssm.dao.UserDao;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/14 19:37
 */
public class SSMTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);
    }
}
