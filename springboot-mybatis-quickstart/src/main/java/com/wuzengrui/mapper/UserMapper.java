package com.wuzengrui.mapper;

import com.wuzengrui.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper //在运行时，会自动生成接口的实现类，并将
public interface UserMapper {

    //查询全部的用户信息
    @Select("select * from user")
    public List<User> list();
}
