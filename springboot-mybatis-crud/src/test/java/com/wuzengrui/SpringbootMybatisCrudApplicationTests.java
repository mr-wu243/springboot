package com.wuzengrui;

import com.wuzengrui.mapper.EmpMapper;
import com.wuzengrui.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testList() {
        List<Emp> emps = empMapper.list(null ,(short) 1, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));
        emps.forEach(emp -> {
            System.out.println(emp);
        });
    }

    @Test
    public void testDelete() {
        System.out.println("删除的记录" + empMapper.delete(17));
    }

    @Test
    public void testInsert() {
        Emp emp = new Emp(null, "Tom", "1234", "汤姆", (short) 1, "1.jpg", (short) 1,
                LocalDate.of(2000, 1, 1), 1, LocalDateTime.now(), LocalDateTime.now());
//        Emp emp = new Emp();
//        emp.setEntrydate(LocalDate.of(2000, 1, 1));
//        emp.setImage("1.jpg");
//        emp.setJob((short) 1);
//        emp.setName("汤姆1");
//        emp.setUsername("Tom1");
//        emp.setUpdateTime(LocalDateTime.now());
//        emp.setCreateTime(LocalDateTime.now());
//        emp.setPassword("1234");
//        emp.setDeptId(1);
//        emp.setGender((short) 1);
        empMapper.insert(emp);
        System.out.println(emp.getId());
    }

    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setImage("1.jpg");
        emp.setJob((short) 1);
        emp.setName("汤姆1");
        emp.setUsername("Tom1");
        emp.setUpdateTime(LocalDateTime.now());
        emp.setCreateTime(LocalDateTime.now());
        emp.setPassword("1234");
        emp.setDeptId(1);
        emp.setId(22);
        emp.setGender((short) 1);
        empMapper.update(emp);
        System.out.println(emp.getId());
    }
    @Test
    public void testUpdate2() {
        Emp emp = new Emp();
        emp.setJob((short) 2);
        emp.setName("汤姆12");
        emp.setUsername("Tom123");
        emp.setUpdateTime(LocalDateTime.now());
        emp.setId(22);
        emp.setGender((short) 1);
        empMapper.update(emp);
        System.out.println(emp.getId());
    }

    @Test
    public void testSelect() {
        Emp emp = empMapper.getEmpById(22);
        System.out.println(emp);
    }
}


