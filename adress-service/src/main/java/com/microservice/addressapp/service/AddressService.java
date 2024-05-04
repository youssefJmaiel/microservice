package com.microservice.addressapp.service;

import com.microservice.addressapp.converter.AddressConverter;
import com.microservice.addressapp.converter.AddressRequestConverter;
import com.microservice.addressapp.dto.AddressDto;
import com.microservice.addressapp.entity.Address;
import com.microservice.addressapp.reponse.AddressResponse;
import com.microservice.addressapp.repository.AddressRepository;
import com.microservice.addressapp.request.AddressRequest;
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

    public Address create(Address address) {

        Address address1 = addressRepository.save(address);
      //  AddressResponse addressResponse = modelMapper.map(address1,AddressResponse.class);
        return address1;
    }

    public AddressDto create(AddressRequest ownerRequest) {
        Address owner = AddressRequestConverter.newInstance().convert(ownerRequest);
        Address savedOwner = addressRepository.save(owner);
        return AddressConverter.newInstance().convert(savedOwner);
    }

    public List<Address> getAllAddresses() {
       return addressRepository.getAllAddresses();
    }
}
