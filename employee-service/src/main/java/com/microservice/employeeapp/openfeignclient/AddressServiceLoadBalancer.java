package com.microservice.employeeapp.openfeignclient;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

@LoadBalancerClient(value = "address-service",configuration = MyCustomerLoadBalancedConfiguration.class)
public class AddressServiceLoadBalancer {
    @LoadBalanced
    @Bean
    public Feign.Builder feiBuilder(){
        return Feign.builder();
    }
}
