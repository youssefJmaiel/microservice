package com.microservice.employeeapp.feignclient;

import com.microservice.employeeapp.response.AddressResponse;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "address",url = "${address.base.url}")
@RibbonClient(name = "employee")
public interface AddressClient {
    @GetMapping("/address/{id}")
    AddressResponse getAddressByEmployeeId(@PathVariable("id") int id);
}
