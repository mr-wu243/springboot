package com.wuzengrui.service.impl;

import com.wuzengrui.annotaion.MyLog;
import com.wuzengrui.mapper.EmpMapper;
import com.wuzengrui.pojo.Emp;
import com.wuzengrui.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Resource(name = "empMapper")
    private EmpMapper empMapper;

    @Override
    public List<Emp> listEmps(String name, Integer gender, LocalDate begin, LocalDate end, int page, int pageSize) {

        return empMapper.listEmp(name, gender, begin, end, (page - 1) * pageSize, pageSize);
    }

    @Override
    @MyLog
    public void delEmp(Integer[] ids) {
        empMapper.delEmpByIds(ids);
    }

    @Override
    @MyLog
    public void insertEmp(Emp emp) {
        empMapper.insertEmp(emp);
    }

    @Override
    public Emp getEmp(Integer id) {
        return empMapper.getEmpById(id);
    }

    @Override
    @MyLog
    public void updateEmp(Emp emp) {
        empMapper.updateEmp(emp);
    }

    @Override
    public int login(String username, String password) {
        return empMapper.loginEmp(username, password);
    }
}
