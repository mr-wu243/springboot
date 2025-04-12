package com.wuzengrui.mapper;

import com.wuzengrui.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    public List<Emp> listEmp(String name, Integer gender, LocalDate begin, LocalDate end,int page,int pageSize);
    public void delEmpByIds(Integer[] ids);
    public void insertEmp(Emp emp);
    public Emp getEmpById(Integer id);
    public void updateEmp(Emp emp);
    public int loginEmp(String username, String password);
    public void deleteEmpByDeptId(Integer deptId);
}
