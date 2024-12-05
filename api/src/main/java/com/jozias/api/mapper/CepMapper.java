package com.jozias.api.mapper;

import com.jozias.api.entitiy.Cep;
import com.jozias.api.dtos.input.CreateCepRequest;
import com.jozias.api.dtos.output.CepResponse;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

@UtilityClass
public class CepMapper {

    public static Cep toDomain(CreateCepRequest createCepRequest) {
        Cep cep = new Cep();
        BeanUtils.copyProperties(createCepRequest, cep);
        return cep;
    }

    public static CepResponse toDto(Cep cep) {
        return new CepResponse(cep.getCep(), cep.getRoad(), cep.getState());
    }
}