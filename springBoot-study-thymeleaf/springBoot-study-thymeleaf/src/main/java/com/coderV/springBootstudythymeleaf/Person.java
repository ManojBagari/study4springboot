package com.coderV.springBootstudythymeleaf;

public class Person {
    private  String name;
    private  int age;
    private String wxCode;

    private int sex;


    public String getWxCode() {
        return wxCode;
    }

    public void setWxCode(String wxCode) {
        this.wxCode = wxCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
