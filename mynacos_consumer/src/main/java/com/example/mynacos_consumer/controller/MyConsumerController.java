package com.example.mynacos_consumer.controller;

import com.example.mynacos_consumer.feigns.MyTestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname MyConsumerController
 * @Description
 * @Date 2022/8/6 12:57
 * @Created by zkj
 */
@RequestMapping("/consum")
@RestController
public class MyConsumerController {
    @Autowired
    private MyTestFeign feign;

    private String name;

    @RequestMapping("/name")
    public String getName(){
        return name==null?"null":name;
    }

    @RequestMapping("/setname")
    public String setName(@PathVariable(name = "name") String name){
        this.name = name;
        return name+"set complete!";
    }

    @RequestMapping("/loadbt")
    public String loadBalancTest(){
        return feign.hello();
    }
}
