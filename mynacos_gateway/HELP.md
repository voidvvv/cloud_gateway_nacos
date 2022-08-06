微服务网关gateway负载均衡实测：

springboot 主启动类添加
@LoadBalancerClient(name = "service-provider",configuration = LoadBalancerConfig.class)
注解，表示对 name 的微服务，使用 LoadBalancerConfig 所配置的负载均衡器
当然，这个注解可以加到任何一个configuration中

- 注意这里的LoadBalancerConfig不能带configuration注解，不能使用自动注入。

自定义实现微服务网关 负载均衡 的方法：
参照springcloud 默认自带的 RandomLoadBalancer，
1. 使用注入的 LoadBalancerClientFactory loadBalancerClientFactory 来进行获取当前所有的微服务
```java
class Test{
    public static void main(String[] args) {
        ServiceInstanceListSupplier supplier = serviceInstanceListSupplierProvider
                .getIfAvailable(NoopServiceInstanceListSupplier::new);
        
        //此时，就可以通过ServiceInstanceListSupplier这个flux
        // 来next获取mono，此 mono中携带的就是当前服务集合。
        
        // 最后就是根据自己的需求，来从服务集合中获取指定想要的服务即可
        // 我自己写的 com/example/mynacos_gateway/loadbalancerclients/MyReactLoadBalancer.java
        // 就是固定选择当前服务列表中第一个服务作为指定的服务
    }
}

```