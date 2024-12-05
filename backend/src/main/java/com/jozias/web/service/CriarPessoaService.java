package com.jozias.web.service;

import com.jozias.web.dto.input.PersonRequest;
import com.jozias.web.entity.Person;

public interface CriarPessoaService {
    Person criar(PersonRequest personRequest);
}
