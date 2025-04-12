package com.wuzengrui.service.impl;

import com.wuzengrui.dao.EmpDao;

import com.wuzengrui.pojo.Emp;
import com.wuzengrui.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

//@Primary
@Service
public class EmpServiceB implements EmpService {
    @Autowired
    private EmpDao dao;

    @Override
    public List<Emp> listEmp() {
        List<Emp> empList=dao.listEmp();
        empList.forEach(emp -> {
            String gender =emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男士");
            }else if("2".equals(gender)){
                emp.setGender("女士");
            }

            String job=emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            }else if("2".equals(job)){
                emp.setJob("班主任");
            }else if("3".equals(job)){
                emp.setJob("就业指导");
            }
        });
        return empList;
    }
}
