package com.wuzengrui.dao.impl;

import com.wuzengrui.dao.EmpDao;
import com.wuzengrui.pojo.Emp;
import com.wuzengrui.utils.XmlParserUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component //将当前类交给IOC容器管理, 成为IOC容器中的bean
@Repository//("daoA")
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        //1. 加载并解析emp.xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
