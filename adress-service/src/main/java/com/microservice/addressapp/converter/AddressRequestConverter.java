package com.microservice.addressapp.converter;

import com.microservice.addressapp.entity.Address;
import com.microservice.addressapp.reponse.AddressResponse;
import com.microservice.addressapp.request.AddressRequest;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;

import java.util.Objects;

@Data(staticConstructor = "newInstance")
public class AddressRequestConverter implements Converter<AddressRequest, Address> {
    @Override
    public Address convert(AddressRequest source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return Address.builder()
                .zip(source.getZip())
                .lane2(source.getLane2())
                .lane1(source.getLane1())
                .state(source.getState())
                .build();
    }
}
