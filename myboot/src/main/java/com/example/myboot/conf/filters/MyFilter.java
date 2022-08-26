package com.example.myboot.conf.filters; /**
 * @Classname ${NAME}
 * @Description ${TODO}
 * @Date 2022/8/23 22:46
 * @Created by voidvvv
 */

import com.example.myboot.conf.wrappers.BodyRepeatableRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.BufferedReader;
import java.io.IOException;

public class MyFilter extends OncePerRequestFilter {


    public void destroy() {
    }



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        BodyRepeatableRequestWrapper wrapper = new BodyRepeatableRequestWrapper(request);
        ServletInputStream inputStream = wrapper.getInputStream();
        BufferedReader reader = wrapper.getReader();

        System.out.println("!!!!");
        filterChain.doFilter(wrapper,new HttpServletResponseWrapper(response));
    }
}
