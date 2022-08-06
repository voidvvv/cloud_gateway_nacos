package com.example.mynacos_provider01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MynacosProvider01Application {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(MynacosProvider01Application.class);
        //添加自定义banner
        springApplication.setBanner(new MyBanner());
        springApplication.run(args);
//        SpringApplication.run(MynacosProvider01Application.class, args);
    }

}
