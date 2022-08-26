package com.example.myboot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Classname MyBean02
 * @Description
 * @Date 2022/8/8 20:44
 * @Created by zkj
 */
@Component
public class MyBean02 {

    public MyBean02() {
        System.out.println("MyBean02 构造方法");
    }
}
