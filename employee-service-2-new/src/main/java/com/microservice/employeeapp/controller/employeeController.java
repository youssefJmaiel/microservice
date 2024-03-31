package com.microservice.employeeapp.controller;

import com.microservice.employeeapp.entity.Employee;
import com.microservice.employeeapp.response.EmployeeResponce;
import com.microservice.employeeapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class employeeController {
    @Autowired
    EmployeeService employeeService;
//    @Autowired
//    RestTemplate restTemplate;

    @GetMapping("/employees/{id}")
    ResponseEntity<EmployeeResponce> getEmployeeDetails(@PathVariable("id") int id){
        EmployeeResponce employeeResponce = employeeService.getEmployeeById(id);

        return ResponseEntity.status(HttpStatus.OK).body(employeeResponce);
    }
}
