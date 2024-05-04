package com.microservice.addressapp.converter;

import com.microservice.addressapp.dto.AddressDto;
import com.microservice.addressapp.entity.Address;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;

import java.util.Objects;
@Data(staticConstructor = "newInstance")
public class AddressConverter implements Converter<Address, AddressDto> {

    @Override
    public AddressDto convert(Address address) {
        if (Objects.isNull(address)) {
            return null;
        }
        return AddressDto.builder()
                .id(address.getId())
                .zip(address.getZip())
                .lane1(address.getLane1())
                .lane2(address.getLane2())
                .state(address.getState())
                .build();
    }
}
