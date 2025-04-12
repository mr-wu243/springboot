package com.wuzengrui.service;

import com.wuzengrui.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> list();

    void delete(Integer id);


    void save(Dept dept);


    Dept getById(Integer id);


    void update(Dept dept);
}
