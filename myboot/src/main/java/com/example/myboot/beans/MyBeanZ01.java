package com.example.myboot.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * @Classname MyBean01
 * @Description
 * @Date 2022/8/8 20:43
 * @Created by zkj
 */
@Component
@Slf4j
@Order(55555)
public class MyBeanZ01 implements InitializingBean,ApplicationContextAware,BeanDefinitionRegistryPostProcessor, BeanNameAware {

    private boolean com(String name){
        return "myBean01".equals(name);
    }
//    @Override
//    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//        if (com(beanName)){
//            log.info("MyBean01  postProcessBeforeInstantiation"+beanName);
//        }
//        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
//    }
//
//    @Override
//    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//        if (com(beanName))
//        log.info("MyBean01  postProcessAfterInstantiation"+beanName);
//        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
//    }
//
//    @Override
//    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
//        if (com(beanName))
//        log.info("MyBean01  postProcessProperties"+beanName);
//        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
//    }
//
//    @Override
//    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
//        if (com(beanName))
//        log.info("MyBean01  postProcessPropertyValues"+beanName);
//        return InstantiationAwareBeanPostProcessor.super.postProcessPropertyValues(pvs, pds, bean, beanName);
//    }
//
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        if (com(beanName))
//        log.info("MyBean01  postProcessBeforeInitialization"+beanName);
//        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        if (com(beanName))
//        log.info("MyBean01  postProcessAfterInitialization"+beanName);
//        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
//    }

    public MyBeanZ01() {

        System.out.println("MyBean01 构造方法");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBean01 postProcessBeanDefinitionRegistry");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBean01 postProcessBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("MyBean01 setApplicationContext");
        String displayName = applicationContext.getDisplayName();
        System.out.println("displayName"+displayName);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("name:"+name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Mybean01 afterPropertiesSet");
    }
}
