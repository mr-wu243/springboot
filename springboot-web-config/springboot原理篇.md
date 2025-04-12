## 配置优先级

优先级排序：命令行参数>Java系统属性>.properties>.yml>.yaml

![img.png](img.png)

打包后的项目如何配置属性：

![img_1.png](img_1.png)

## Bean管理

### 获取bean
![img_2.png](img_2.png)

![img_3.png](img_3.png)

### bean的作用域

![img_4.png](img_4.png)

配置bean的作用域

![img_5.png](img_5.png)

关于@Lazy的说明：

对于一些不常用的Bean，延迟加载可以避免在启动时初始化所有Bean，从而减少启动时间;  按需加载资源：某些Bean依赖于外部资源（如数据库连接或远程服务），在系统启动时可能不需要立即加载。

注意：

![img_6.png](img_6.png)

### 第三方bean

![img_7.png](img_7.png)

![img_8.png](img_8.png)

![img_9.png](img_9.png)

像这样：

![img_10.png](img_10.png)

使用场景：

![img_11.png](img_11.png)

# Springboot原理

## 起步依赖
![img_12.png](img_12.png)

相较于spring框架，不容易出现版本冲突问题，一切都是maven的依赖传递的功劳

## 自动配置

![img_13.png](img_13.png)

### 自动配置原理

@SpringBootApplication扫描bean对象的范围是：当前包及其子包

如果想配置其他包中的bean对象则有以下方案：

1.![img_14.png](img_14.png)

如果用@ComponentScan这个标签的话，原来的@SpringbootApplication扫描的包就会被覆盖，所以一般需要加上当前包，而且每添加一个包就需要在@ComponentScan中添加新的包名，非常繁琐

2.![img_15.png](img_15.png)
![img_16.png](img_16.png)
![img_17.png](img_17.png)

Springboot使用的方式：一般都在第三方依赖的@EnableXXXX注解标明哪些依赖是需要引入的


原码跟踪：
![img_18.png](img_18.png)
![img_19.png](img_19.png)


#### @Conditional
![img_20.png](img_20.png)
![img_21.png](img_21.png)

#### 自定义 starter
![img_22.png](img_22.png)




![img_24.png](img_24.png)