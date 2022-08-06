package com.example.mynacos_consumer.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname MyTestFeign
 * @Description
 * @Date 2022/8/6 13:03
 * @Created by zkj
 */
@FeignClient(name = "mygateway",path = "/serviceProvider")
public interface MyTestFeign {

    @RequestMapping("/test/hello")
    public String hello();
}
