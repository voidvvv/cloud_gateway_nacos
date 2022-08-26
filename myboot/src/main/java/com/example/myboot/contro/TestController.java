package com.example.myboot.contro;

import com.example.myboot.dto.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Classname TestController
 * @Description
 * @Date 2022/8/23 23:45
 * @Created by voidvvv
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/u")
    public String test(@RequestBody User user){
        System.out.println(user);
        return "hello!";
    }

    @RequestMapping("/u2")
    public String test02(@RequestPart(name = "name") String name, @RequestPart(name = "name")MultipartFile file){
        System.out.println(file.getOriginalFilename());
        return name;
    }
}
