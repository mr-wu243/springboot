package com.wuzengrui.service;


import com.wuzengrui.pojo.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> listDepts();
    public Dept getDeptById(Integer id);
    public void deleteDept(Integer id);
    public void addDept(Dept dept);
    public void updateDept(Dept dept);
}
