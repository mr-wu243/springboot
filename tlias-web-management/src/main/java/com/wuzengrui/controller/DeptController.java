package com.wuzengrui.controller;

import com.wuzengrui.mapper.DeptMapper;
import com.wuzengrui.pojo.Dept;
import com.wuzengrui.pojo.Result;
import com.wuzengrui.service.DeptService;
import jakarta.annotation.Resource;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
//公共路径抽取
@RequestMapping("/depts")

public class DeptController {

//    private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Resource(name = "deptServiceImpl")
    private DeptService deptService;

    @GetMapping("")
    public Result listDepts() {
        log.info("查询所有部门数据");
        List<Dept> deptList = deptService.listDepts();
        return Result.success(deptList);
    }

    @GetMapping("/{id}")
    public Result getDept(@PathVariable Integer id) {
        Dept dept = deptService.getDeptById(id);
        return Result.success(Objects.requireNonNullElse(dept, "不存在"));

    }

    @DeleteMapping("/{id}")
    public Result deleteDept(@PathVariable Integer id) {
        log.info("删除部门");
        deptService.deleteDept(id);
        return Result.success("删除成功");
    }

    @PostMapping("")
    public Result addDept(@RequestBody JsonNode jsonNode) {
        String name = jsonNode.get("name").asText();
        log.info("添加部门");
        Dept dept = new Dept();
        dept.setName(name);
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptService.addDept(dept);
        return Result.success("部门添加成功");
    }

    @PutMapping
    public Result updateDept(@RequestBody Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptService.updateDept(dept);
        return Result.success();
    }
}
