package com.wuzengrui.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//public class User {
//    private Integer id;
//    private String name;
//    private short age;
//    private String phone;
//    private short gender;
//
//    public User() {
//    }
//
//    public User(Integer id, String phone, short age, String name, short gender) {
//        this.id = id;
//        this.phone = phone;
//        this.age = age;
//        this.name = name;
//        this.gender = gender;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public short getAge() {
//        return age;
//    }
//
//    public void setAge(short age) {
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public short getGender() {
//        return gender;
//    }
//
//    public void setGender(short gender) {
//        this.gender = gender;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", phone='" + phone + '\'' +
//                ", gender=" + gender +
//                '}';
//    }
//}
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
    private Integer id;
    private String name;
    private short age;
    private String phone;
    private short gender;
}