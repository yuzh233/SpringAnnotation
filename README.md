<!-- TOC -->

- [组件注册](#组件注册)
- [生命周期](#生命周期)
- [属性赋值](#属性赋值)
- [自动装配](#自动装配)
- [AOP](#aop)
- [事务](#事务)
- [原理](#原理)
- [Servlet](#servlet)
- [SpringMVC](#springmvc)

<!-- /TOC -->

## 组件注册

- [@Configuration](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig.java)
- [@ComponentScan](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig.java)
- [@Bean](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig.java)
- [@Scope](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig2.java)
- [@Lazy](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig2.java)
- [@Conditional](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig2.java)
- [@Import](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig2.java)

## 生命周期

- [@Bean 指定初始化和销毁方法](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig3.java)
- [实现 InitializingBean和DisposableBean 指定初始化和销毁方法](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/pojo/Dog.java)
- [@PostConstruct / @PreDestroy 指定初始化和销毁方法](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/pojo/Cat.java)

## 属性赋值

- [@Value 赋值](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/pojo/Person.java)
- [@PropertySource 加载外部配置文件](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/pojo/Person.java)

## 自动装配

- [@Autowired / @Qualifier / @Primary](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig5.java)
- [@Resource / @Inject](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig5.java)
- [实现 Aware 注入 Spring 底层组件](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/pojo/Red.java)
- [@Profile 环境搭建](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig6.java)
- [@Profile 环境激活](https://github.com/yuzh233/SpringAnnotation/blob/master/src/test/xyz/yuzh/learn/spring/annotation/test/Main6Test.java)

## AOP

- [@Aspect / @Pointcut / @Before / @After / @AfterReturning / @AfterThrowing / @Around ](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/aop/LogAspect.java)
- [@EnableAspectJAutoProxy](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig7.java)

## 事务

- [@Transactional](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/service/UserService.java)
- [@EnableTransactionManagement](https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig8.java)
- [DataSource / Template / PlatformTransactionManager](https://github.com/yuzh233/SpringAnnotation/blob/master/https://github.com/yuzh233/SpringAnnotation/blob/master/src/main/java/xyz/yuzh/learn/spring/annotation/config/MainConfig8.java)



## 原理
## Servlet
## SpringMVC