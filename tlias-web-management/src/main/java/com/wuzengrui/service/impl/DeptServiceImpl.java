package com.wuzengrui.service.impl;

import com.wuzengrui.annotaion.MyLog;
import com.wuzengrui.mapper.DeptMapper;
import com.wuzengrui.mapper.EmpMapper;
import com.wuzengrui.pojo.Dept;
import com.wuzengrui.service.DeptService;
import com.wuzengrui.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Resource(name = "deptMapper")
    private DeptMapper deptMapper;
    @Resource(name = "empMapper")
    private EmpMapper empMapper;

    @Override
    public List<Dept> listDepts() {
        return deptMapper.listDepts();
    }

    @Override
    public Dept getDeptById(Integer id) {
        return deptMapper.getDeptById(id);
    }

    @Override
    @Transactional
    @MyLog
    public void deleteDept(Integer id) {
        deptMapper.deleteDept(id);
//        int i=1/0;
        empMapper.deleteEmpByDeptId(id);
    }

    @Override
    @MyLog
    public void addDept(Dept dept) {
        deptMapper.insertDept(dept);
    }

    @Override
    @MyLog
    public void updateDept(Dept dept) {
        deptMapper.updateDept(dept);
    }
}
