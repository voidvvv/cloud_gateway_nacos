package com.example.mynacos_gateway.loadbalancerclients;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @Classname LoadBalancerConfig
 * @Description
 * @Date 2022/8/6 13:17
 * @Created by zkj
 */
//@Configuration
public class LoadBalancerConfig {
    @Bean
    public ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment, LoadBalancerClientFactory loadBalancerClientFactory){
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new MyReactLoadBalancer(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
    }

//    @Bean
//    public ReactorLoadBalancer<ServiceInstance> randomLoadBalancer02(Environment environment, LoadBalancerClientFactory loadBalancerClientFactory){
//        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//        return new MyRandomLoadBalancer02(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
//    }
}
