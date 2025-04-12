# mybatis增删改查（crud）

## 删
![img.png](img.png)
## 增
![img_4.png](img_4.png)
可以自动识别对象中的属性

### 主键返回
![img_6.png](img_6.png)

## 获取mybatis日志

语法：
mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl

![img_1.png](img_1.png)

# 查

![img_7.png](img_7.png)

模糊匹配时用字符串拼接
![img_13.png](img_13.png)
或者使用concat对字符串进行拼接
![img_14.png](img_14.png)
## 数据封装
![img_8.png](img_8.png)
![img_12.png](img_12.png)
解决方法
* 1：起别名
![img_9.png](img_9.png)
让字段名和实体类的属性名一致
* 2：用@Results和@Result标签
![img_10.png](img_10.png)
* 3：开启mybatis的驼峰命名自动映射开关
![img_11.png](img_11.png)
## 安全性的说明（sql注入）
![img_2.png](img_2.png)
![img_3.png](img_3.png)
