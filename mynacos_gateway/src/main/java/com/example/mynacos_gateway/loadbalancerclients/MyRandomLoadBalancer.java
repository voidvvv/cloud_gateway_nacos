package com.example.mynacos_gateway.loadbalancerclients;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Mono;

/**
 * @Classname MyRandomLoadBalancer
 * @Description
 * @Date 2022/8/6 13:16
 * @Created by zkj
 */
public class MyRandomLoadBalancer extends RandomLoadBalancer {

    public MyRandomLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider, String serviceId) {
        super(serviceInstanceListSupplierProvider, serviceId);
    }

    @Override
    public Mono<Response<ServiceInstance>> choose() {
        System.out.println("my choose 01!");
        return super.choose();
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        System.out.println("my choose request 01!"+request);
        return super.choose(request);
    }
}
