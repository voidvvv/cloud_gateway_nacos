package com.example.myboot.dto;

/**
 * @Classname User
 * @Description
 * @Date 2022/8/23 23:46
 * @Created by voidvvv
 */
public class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
}
