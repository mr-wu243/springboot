package com.wuzengrui.controller;

import com.wuzengrui.pojo.Address;
import com.wuzengrui.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResponseController {
    //    @RequestMapping("/hello")
//    public String hello() {
//        System.out.println("hello");
//        return "hello";
//    }
//
//    @RequestMapping("/getAddr")
//    public Address getAddr() {
//        Address address = new Address();
//        address.setProvince("北京");
//        address.setCity("北京");
//        return address;
//    }
//
//    @RequestMapping("/listArray")
//    public List<Address> listArray() {
//        List<Address> list = new ArrayList<Address>();
//        Address address1 = new Address();
//        address1.setProvince("北京");
//        address1.setCity("北京");
//        Address address2 = new Address();
//        address2.setCity("上海");
//        address2.setProvince("上海");
//        list.add(address1);
//        list.add(address2);
//        return list;
//    }
    @RequestMapping("/hello")
    public Result hello() {
        System.out.println("hello");
        return Result.success("hello");
    }

    @RequestMapping("/getAddr")
    public Result getAddr() {
        Address address = new Address();
        address.setProvince("北京");
        address.setCity("北京");
        return Result.success(address);
    }

    @RequestMapping("/listArray")
    public Result listArray() {
        List<Address> list = new ArrayList<Address>();
        Address address1 = new Address();
        address1.setProvince("北京");
        address1.setCity("北京");
        Address address2 = new Address();
        address2.setCity("上海");
        address2.setProvince("上海");
        list.add(address1);
        list.add(address2);
        return Result.success(list);
    }
}
