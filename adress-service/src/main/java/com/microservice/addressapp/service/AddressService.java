package com.microservice.addressapp.service;

import com.microservice.addressapp.entity.Address;
import com.microservice.addressapp.reponse.AddressResponse;
import com.microservice.addressapp.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ModelMapper modelMapper;

    public AddressResponse findAddressByEmployeeId(int employeeId){
        Address address = addressRepository.findAddressByEmployeeId(employeeId);
        AddressResponse addressResponse = modelMapper.map(address,AddressResponse.class);
        return addressResponse;

    }

    public List<Address> getAllAddresses() {
       return addressRepository.getAllAddresses();
    }
}
