package com.jozias.api.service;

import com.jozias.api.entitiy.Cep;
import com.jozias.api.dtos.input.CreateCepRequest;

public interface CreateCepService {
    Cep create(CreateCepRequest createCepRequest);
}
