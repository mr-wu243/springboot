package com.wuzengrui.controller;

import com.wuzengrui.pojo.Emp;
import com.wuzengrui.pojo.Result;
import com.wuzengrui.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/emps")
public class EmpController {

    @Resource(name = "empServiceImpl")
    private EmpService empService;

    @GetMapping
    public Result getEmp(@RequestParam(required = false) String name, @RequestParam(required = false) Integer gender, @RequestParam(required = false) LocalDate begin, @RequestParam(required = false) LocalDate end, @RequestParam int page, @RequestParam int pageSize) {
        return Result.success(empService.listEmps(name, gender, begin, end, page, pageSize));
    }

    @GetMapping("/{id}")
    public Result getEmpById(@PathVariable int id) {
        return Result.success(empService.getEmp(id));
    }

    @DeleteMapping("/{ids}")
    public Result deleteEmp(@PathVariable Integer[] ids) {
        for (int i = 0; i < ids.length; i++) {
            System.out.println(ids[i]);
        }
        empService.delEmp(ids);
        return Result.success();
    }

    @PostMapping
    public Result addEmp(@RequestBody Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        try{
            empService.insertEmp(emp);
        }
        catch (Exception e){
            return Result.error("信息不全");
        }
        return Result.success();
    }

    @PutMapping
    public Result updateEmp(@RequestBody Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empService.updateEmp(emp);
        return Result.success();
    }
}
