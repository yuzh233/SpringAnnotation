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

- [@Configuration](src\main\java\xyz\yuzh\learn\spring\annotation\config\MainConfig.java)
- [@ComponentScan](src\main\java\xyz\yuzh\learn\spring\annotation\config\MainConfig.java)
- [@Bean](src\main\java\xyz\yuzh\learn\spring\annotation\config\MainConfig.java)
- [@Scope](src\main\java\xyz\yuzh\learn\spring\annotation\config\MainConfig2.java)
- [@Lazy](src\main\java\xyz\yuzh\learn\spring\annotation\config\MainConfig2.java)
- [@Conditional](src\main\java\xyz\yuzh\learn\spring\annotation\config\MainConfig2.java)
- [@Import](src\main\java\xyz\yuzh\learn\spring\annotation\config\MainConfig2.java)

## 生命周期

- [@Bean 指定初始化和销毁方法](src\main\java\xyz\yuzh\learn\spring\annotation\config\MainConfig3.java)
- [实现 InitializingBean和DisposableBean 指定初始化和销毁方法](src\main\java\xyz\yuzh\learn\spring\annotation\pojo\Dog.java)
- [@PostConstruct / @PreDestroy 指定初始化和销毁方法](src\main\java\xyz\yuzh\learn\spring\annotation\pojo\Cat.java)

## 属性赋值

- [@Value 赋值](src\main\java\xyz\yuzh\learn\spring\annotation\pojo\Person.java)
- [@PropertySource 加载外部配置文件](src\main\java\xyz\yuzh\learn\spring\annotation\pojo\Person.java)

## 自动装配

- [@Autowired / @Qualifier / @Primary](src\main\java\xyz\yuzh\learn\spring\annotation\config\MainConfig5.java)
- [@Resource / @Inject](src\main\java\xyz\yuzh\learn\spring\annotation\config\MainConfig5.java)
- [实现 Aware 注入 Spring 底层组件](src\main\java\xyz\yuzh\learn\spring\annotation\pojo\Red.java)
- [@Profile 环境搭建](src\main\java\xyz\yuzh\learn\spring\annotation\config\MainConfig6.java)
- [@Profile 环境激活](src\test\xyz\yuzh\learn\spring\annotation\test\Main6Test.java)

## AOP

- [@Aspect / @Pointcut / @Before / @After / @AfterReturning / @AfterThrowing / @Around ](src\main\java\xyz\yuzh\learn\spring\annotation\aop\LogAspect.java)
- [@EnableAspectJAutoProxy](src\main\java\xyz\yuzh\learn\spring\annotation\config\MainConfig7.java)

## 事务

- [@Transactional](src\main\java\xyz\yuzh\learn\spring\annotation\service\UserService.java)
- [@EnableTransactionManagement](src\main\java\xyz\yuzh\learn\spring\annotation\config\MainConfig8.java)
- [DataSource / Template / PlatformTransactionManager](src\main\java\xyz\yuzh\learn\spring\annotation\config\MainConfig8.java)

## 原理
## Servlet
## SpringMVC