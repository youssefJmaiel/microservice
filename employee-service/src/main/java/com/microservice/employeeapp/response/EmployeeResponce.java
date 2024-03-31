package com.microservice.employeeapp.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponce {

    private int id;
    private String name;
    private String email;
    private String bloodGroup;
    private  AddressResponse addressResponse;
}
