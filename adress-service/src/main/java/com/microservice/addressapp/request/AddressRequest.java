package com.microservice.addressapp.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    private String lane1;
    private String lane2;
    private long zip;
    private String state;
}
