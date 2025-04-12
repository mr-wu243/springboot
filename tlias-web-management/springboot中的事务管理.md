# 事务管理出现的情景
![img_39.png](img_39.png)

# 事物管理的注解

![img_40.png](img_40.png)

springboot开启事物管理日志的设置

```yml
logging:
 level:
  org.springframework.jdbc.support.JdbcTransactionManager: debug
```

## rollbackFor
默认是RuntimeException
![img_41.png](img_41.png)


## propagation
![img_42.png](img_42.png)

## propagation的行为种类
![img_43.png](img_43.png)

## 案例
![img_44.png](img_44.png)

分析：
因为无论能否成功解散部门，日志都需要记录，所以记录日志和解散部门是两种不同的事物，所以记录日志的方法的propagate的值应该是propagate.REQUIRES_NEW