package com.jozias.api.service.impl;

import com.jozias.api.entitiy.Cep;
import com.jozias.api.exception.CepNotFoundException;
import com.jozias.api.repository.CepRepository;
import com.jozias.api.service.SearchCepService;
import org.springframework.stereotype.Service;

@Service
public class SearchCepServiceImpl implements SearchCepService {

    private final CepRepository cepRepository;

    public SearchCepServiceImpl(final CepRepository cepRepository) {
        this.cepRepository = cepRepository;
    }

    @Override
    public Cep search(String cep) {
        return cepRepository.findByCep(cep).orElseThrow(() -> new CepNotFoundException("Cep não encontrado"));
    }
}
