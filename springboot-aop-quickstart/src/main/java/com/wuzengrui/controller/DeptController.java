package com.wuzengrui.controller;

import com.wuzengrui.pojo.Dept;
import com.wuzengrui.pojo.Result;
import com.wuzengrui.service.DeptService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depts")
public class DeptController {

    @Resource(name = "deptServiceImpl")
    private DeptService deptService;

    //查询全部部门
    @GetMapping
    public Result list(){
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    //删除部门
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id)  {
        deptService.delete(id);
        return Result.success();
    }

    //添加部门
    @PostMapping
    public Result save(@RequestBody Dept dept){
        deptService.save(dept);
        return Result.success();
    }

    //根据ID查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Dept dept =  deptService.getById(id);
        return Result.success(dept);
    }

    //更新部门
    @PutMapping
    public Result update(@RequestBody Dept dept){
        deptService.update(dept);
        return Result.success();
    }
}
