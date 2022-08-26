package com.example.mynacos_gateway;

import com.example.mynacos_gateway.loadbalancerclients.LoadBalancerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;

@SpringBootApplication
@EnableDiscoveryClient
@LoadBalancerClient(name = "service-provider",configuration = LoadBalancerConfig.class)
@LoadBalancerClients(value = {@LoadBalancerClient()})
public class MynacosGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MynacosGatewayApplication.class, args);
    }

}
