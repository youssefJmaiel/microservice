package com.microservice.addressapp.controller;

import com.microservice.addressapp.entity.Address;
import com.microservice.addressapp.reponse.AddressResponse;
import com.microservice.addressapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;
    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressResponce(@PathVariable("employeeId") int id){

        AddressResponse addressResponse = null;

       addressResponse = addressService.findAddressByEmployeeId(id);


        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);

    }
    @GetMapping("/address/all")
    public ResponseEntity<List<Address>> getAllAddressResponce(){

        List<Address> addressResponse = addressService.getAllAddresses();


        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);

    }
}
