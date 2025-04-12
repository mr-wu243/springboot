package com.wuzengrui.dao;

import com.wuzengrui.pojo.Emp;
import com.wuzengrui.utils.XmlParserUtils;

import java.util.List;

public interface EmpDao {
//    获取员工数据
    public List<Emp> listEmp();
}
