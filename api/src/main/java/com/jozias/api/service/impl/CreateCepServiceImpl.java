package com.jozias.api.service.impl;

import com.jozias.api.entitiy.Cep;
import com.jozias.api.dtos.input.CreateCepRequest;
import com.jozias.api.exception.CepAlreadySavedException;
import com.jozias.api.mapper.CepMapper;
import com.jozias.api.repository.CepRepository;
import com.jozias.api.service.CreateCepService;
import org.springframework.stereotype.Service;

@Service
public class CreateCepServiceImpl implements CreateCepService {
    private final CepRepository cepRepository;

    public CreateCepServiceImpl(final CepRepository cepRepository) {
        this.cepRepository = cepRepository;
    }

    @Override
    public Cep create(final CreateCepRequest createCepRequest) {
        validCepUniqueness(createCepRequest);
        return cepRepository.save(CepMapper.toDomain(createCepRequest));
    }

    private void validCepUniqueness(final CreateCepRequest createCepRequest) {
        cepRepository.findByCep(createCepRequest.cep())
                .ifPresent(cep -> {
                    throw new CepAlreadySavedException("Cep já cadastrado");
                });
    }

}
