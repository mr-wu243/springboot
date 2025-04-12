# AOP(通过CGLIB实现，CGLIB通过拦截器实现)
![img_45.png](img_45.png)

![img_46.png](img_46.png)

## 基本实现
![img_47.png](img_47.png)

## 场景和优势
![img.png](img.png)

## 核心概念
![img_1.png](img_1.png)

## 执行流程
![img_2.png](img_2.png)

## 通知类型
![img_3.png](img_3.png)

注意：
* @After和@AfterReturning的区别：@After不管原始方法调用是否成功，都执行，@AfterReturning只有在原始方法正常执行时才会执行
* @Around在原始方法后面的通知只有在原始方法成功调用时才会运行，类似于@AfterReturning
* ![img_4.png](img_4.png)

## 切入点表达式提取
定义：
```java
@Pointcut("execution(* com.wuzengrui.service.impl.DeptServiceImpl.*(..))")
    public void pt(){}
```

使用：
```java
@Before("pt()")
public void before(){
    log.info("before ...");
}
```

## 通知顺序

![img_5.png](img_5.png)
![img_6.png](img_6.png)

## 切入点表达式

![img_7.png](img_7.png)

### execution
![img_8.png](img_8.png)

execution(public void com.wuzengrui.service.imp.DeptServiceImpl.delete(java.lang.Integer))
![img_9.png](img_9.png)

多个切入点的表达式

![img_10.png](img_10.png)

#### 书面建议
![img_11.png](img_11.png)

### annotation

创建一个annotation
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyLog {
}
```
然后在想要切入的方法上加上@MyLog标签
最后在aop上注释annotation所在的包就行了
例如：

```java
import org.aspectj.lang.annotation.Around;

@Around("@annotaion(com.wuzengrui.aop.MyLog)")
```
![img_12.png](img_12.png)

## 连接点
![img_13.png](img_13.png)
