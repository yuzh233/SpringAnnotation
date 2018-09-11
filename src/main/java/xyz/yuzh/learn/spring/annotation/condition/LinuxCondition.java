package xyz.yuzh.learn.spring.annotation.condition;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 16:33
 * <p>
 * 指定创建Bean的条件类
 */
public class LinuxCondition implements Condition {
    private static final String CONDITION = "Linux";

    /**
     * 判断是否为linux系统
     *
     * @param context               条件判断的上下文（环境）
     * @param annotatedTypeMetadata 注释信息
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");
        if (osName.contains(CONDITION)) return true;
        return false;
    }
}
