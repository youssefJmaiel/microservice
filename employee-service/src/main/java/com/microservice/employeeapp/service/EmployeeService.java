package com.microservice.employeeapp.service;

import com.microservice.employeeapp.entity.Employee;
import com.microservice.employeeapp.openfeignclient.AddressClient;
import com.microservice.employeeapp.repostitory.EmployeeRepository;
import com.microservice.employeeapp.response.AddressResponse;
import com.microservice.employeeapp.response.EmployeeResponce;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;
//    @Autowired
//    private WebClient webClient;
//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private AddressClient addressClient;

//    @Autowired
//    private DiscoveryClient discoveryClient;

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;



    public EmployeeResponce getEmployeeById(int id){

        Employee employee =  employeeRepository.findById(id).get();
        EmployeeResponce employeeResponce = modelMapper.map(employee,EmployeeResponce.class);
//        AddressResponse  addressResponse = callingAddressServiceUsingRestTemplate(id);
//        employeeResponce.setAddressResponse(addressResponse);
//
//        return employeeResponce;
        ResponseEntity<AddressResponse> addressResponseEntity = addressClient.getAddressByEmployeeId(id);
        AddressResponse  addressResponse = addressResponseEntity.getBody();
        employeeResponce.setAddressResponse(addressResponse);
        return employeeResponce;
    }

//    private AddressResponse callToAddressServiceUsingWebClient(int id) {
//        return webClient.get().uri("/address/" + id)
//                .retrieve()
//                .bodyToMono(AddressResponse.class).block();
//    }

//    private AddressResponse callingAddressServiceUsingRestTemplate(int id){
////        List<ServiceInstance> instances = discoveryClient.getInstances("address");
////        ServiceInstance serviceInstance = instances.get(0);
////        String uri = serviceInstance.getUri().toString();
////        ServiceInstance serviceInstance = loadBalancerClient.choose("address");
////        String uri = serviceInstance.getUri().toString();
//
////        return restTemplate.getForObject("http://ADDRESS/address/{id}",AddressResponse.class,id);
//    }

    public List<Employee> getAllAddresses() {
        return employeeRepository.getAllAddresses();
    }































}
