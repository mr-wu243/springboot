package com.wuzengrui.controller;

import com.wuzengrui.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@RestController
public class RequestController {
//    @RequestMapping("/simpleParam")
//    public String simpleParam(HttpServletRequest request) {
//        String name=request.getParameter("name");
//        String age=request.getParameter("age");
//        int age1=Integer.parseInt(age);
//        System.out.println("name="+name+",age="+age1);
//        return "OK";
//    }
//    @RequestMapping("/simpleParam")
//    public String simpleParam(String name,Integer age) {
//        System.out.println("name="+name+",age="+age);
//        return "OK";
//    }
//    传递简单参数
    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name="name" ,required = false) String username, Integer age) {
        System.out.println("name="+username+",age="+age);
        return "OK";
    }

    @RequestMapping("/simplePojo")
    public String simplePojo(User user) {
        System.out.println("age="+user.getAge());
        System.out.println("name="+user.getName());
        System.out.println("province="+user.getAddress().getProvince());
        System.out.println("city="+user.getAddress().getCity());
        return "OK";
    }
//    传递复杂参数
    @RequestMapping("/complexPojo")
    public String complexPojo(User user) {
        System.out.println("age="+user.getAge());
        System.out.println("name="+user.getName());
        System.out.println("province="+user.getAddress().getProvince());
        System.out.println("city="+user.getAddress().getCity());
        return "OK";
    }
//数组形式
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println("hobby="+ Arrays.toString(hobby));
        return "OK";
    }
//集合形式
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "OK";
    }

    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println(updateTime);
        return "OK";
    }
//接收json格式参数可以用类来接收，但是注意需要用@RequestBody进行标识
    @RequestMapping("/jsonParam")
    public String json(@RequestBody User user) {
        System.out.println("age="+user.getAge());
        System.out.println("name="+user.getName());
        System.out.println("province="+user.getAddress().getProvince());
        System.out.println("city="+user.getAddress().getCity());
        return "OK";
    }
//   路径传递参数比如http://local:8080/path/1，后面的1就是要传递的参数,需要用@PathVariable标记
    @RequestMapping("/path/{id}")
    public String path(@PathVariable Integer id) {
        System.out.println(id);
        return "OK";
    }

    @RequestMapping("/path/{id}/{name}")
    public String path(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(id);
        System.out.println(name);
        return "OK";
    }
}
