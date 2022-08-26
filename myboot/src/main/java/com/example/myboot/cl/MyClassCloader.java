package com.example.myboot.cl;

/**
 * @Classname MyClassCloader
 * @Description
 * @Date 2022/8/8 23:52
 * @Created by zkj
 */
public class MyClassCloader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
