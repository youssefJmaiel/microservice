package com.microservice.employeeapp.openfeignclient;

import com.microservice.employeeapp.response.AddressResponse;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "address-service",path = "/demo-api/")
public interface AddressClient {

    @GetMapping("/address/{id}")
    ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("id") int id);
}
