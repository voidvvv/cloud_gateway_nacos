package com.example.myboot.conf;

import com.example.myboot.beans.MySocketHandler;
import com.example.myboot.conf.filters.MyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.*;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Classname MyConf
 * @Description
 * @Date 2022/8/23 19:45
 * @Created by voidvvv
 */
@Configuration
public class MyConf implements WebSocketConfigurer {

    @Autowired(required = false)
    private MyFilter myFilter;

    @Autowired
    private MySocketHandler mySocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(mySocketHandler,"myws").setAllowedOrigins("*");
    }

    @Bean(name = "")
    public FilterRegistrationBean f01(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(myFilter);
        bean.addUrlPatterns("/*");
        return bean;
    }
}
