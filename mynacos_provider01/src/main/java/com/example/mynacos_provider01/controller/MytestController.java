package com.example.mynacos_provider01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname MytestController
 * @Description
 * @Date 2022/8/6 9:32
 * @Created by zkj
 */
@RestController
@RequestMapping("/test")
public class MytestController {

    //获取web监听的端口
    @Autowired
    private Environment environment;

    private String getPort(){
        return environment.getProperty("local.server.port");
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hi,"+this.getPort();
    }
}
