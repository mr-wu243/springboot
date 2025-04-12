package com.wuzengrui.service;


import com.wuzengrui.pojo.Emp;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    public List<Emp> listEmps(String name, Integer gender, LocalDate begin, LocalDate end,int page,int pageSize);
    public void delEmp(Integer[] ids);
    public void insertEmp(Emp emp);
    public Emp getEmp(Integer id);
    public void updateEmp(Emp emp);
    public int login(String username, String password);
}
