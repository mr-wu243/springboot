# 应用场景
![img_20.png](img_20.png)

## <if>
如果判断为true则拼接相应的sql语句
案例：
![img_22.png](img_22.png)

where标签的作用，如果后面的if条件全部为false时则不会生成where关键字，并且判断是否需要添加and关键字（比如案例中如果没有传递name属性而传递gender属性时，前面的and关键字就不会被添加）

强化案例：
![img_21.png](img_21.png)

## <foreach>(批量删除)

![img_23.png](img_23.png)
![img_24.png](img_24.png)
![img_25.png](img_25.png)

## <sql><include>

使用前：
![img_26.png](img_26.png)
使用后：
![img_27.png](img_27.png)
![img_28.png](img_28.png)