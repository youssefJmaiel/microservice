package com.microservice.employeeapp.service;

import com.microservice.employeeapp.entity.Employee;
import com.microservice.employeeapp.feignclient.AddressClient;
import com.microservice.employeeapp.repostitory.EmployeeRepository;
import com.microservice.employeeapp.response.AddressResponse;
import com.microservice.employeeapp.response.EmployeeResponce;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressClient addressClient;
    @Autowired
    private ModelMapper modelMapper;


    public EmployeeResponce getEmployeeById(int id){

        Employee employee =  employeeRepository.findById(id).get();
        EmployeeResponce employeeResponce = modelMapper.map(employee,EmployeeResponce.class);
        AddressResponse  addressResponse = addressClient.getAddressByEmployeeId(id);
        employeeResponce.setAddressResponse(addressResponse);

        return employeeResponce;
    }

































}
