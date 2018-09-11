package xyz.yuzh.learn.spring.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/11 17:34
 * <p>
 * 切面类
 * <p>
 * 1. 将业务逻辑组件和切面类都加入到容器中；告诉Spring哪个是切面类（@Aspect）
 * 2. 在切面类上的每一个通知方法上标注通知注解，告诉Spring何时何地运行（切入点表达式）
 * 3. 开启基于注解的aop模式；@EnableAspectJAutoProxy
 */
@Aspect
public class LogAspect {
    /**
     * 切入点
     */
    @Pointcut("execution(* xyz.yuzh.learn.spring.annotation.aop.*.*(..))")
    public void pointCut() {
    }

    /**
     * 前置通知：目标方法执行前运行
     */
    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("[before] " + joinPoint.getSignature() + " -> args: " + Arrays.toString(args));
    }

    /**
     * 后置通知：目标方法结束后运行（不论是否出现异常）
     */
    @After(value = "pointCut()")
    public void After(JoinPoint joinPoint) {
        System.out.println("[after] " + joinPoint.getSignature() + " is over");
    }

    /**
     * 返回通知：正常返回后运行
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void AfterReturning(JoinPoint joinPoint, Object result) { // JoinPoint必须是第一个参数
        System.out.println("[afterReturning] " + joinPoint.getSignature() + " -> result: " + result);
    }

    /**
     * 出现异常返回
     */
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void AfterThrowing(JoinPoint joinPoint, Exception exception) {
        System.out.println("[afterThrowing] " + joinPoint.getSignature() + " -> exception: [" + exception + " ]");
    }

    /**
     * 环绕通知：动态代理，手动推进目标方法运行 joinPoint.procced()
     * <p>
     * Around 拥有 Before 和 After 的功能，并且能决定目标方法什么时候执行，怎么执行，甚至阻断执行。
     * 第一个形参必须是ProceedJoinPoint类型
     */
//    @Around(value = "pointCut()")
    public int around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("[around before]");
        proceedingJoinPoint.proceed();// 执行目标方法
        System.out.println("[around after]");
        return 0;
    }

}
