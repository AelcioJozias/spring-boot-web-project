package com.jozias.web.mapper;

import com.jozias.web.dto.input.AddressRequest;
import com.jozias.web.entity.Address;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

@UtilityClass
public class AddressMapper {
    public static Address toEntity(AddressRequest request) {
        Address address = new Address();
        BeanUtils.copyProperties(request, address);
        return address;
    }
}
