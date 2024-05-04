package com.microservice.addressapp.controller;

import com.microservice.addressapp.dto.AddressDto;
import com.microservice.addressapp.entity.Address;
import com.microservice.addressapp.reponse.AddressResponse;
import com.microservice.addressapp.request.AddressRequest;
import com.microservice.addressapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
//
//    @PostMapping("/address/create")
//    public ResponseEntity<Address> createAddress(Address addressResponse){
//
//
//
//       Address  address = addressService.create(addressResponse);
//
//
//        return ResponseEntity.status(HttpStatus.OK).body(address);
//
//    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE, path = "/address/create")
    public ResponseEntity<AddressDto> create(@RequestBody AddressRequest addressRequest) {
        AddressDto ownerDto = addressService.create(addressRequest);
        final URI location = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/demo-api/address/create/{id}").build().expand(ownerDto.getId()).toUri();
        return ResponseEntity.created(location).body(ownerDto);
    }
}
