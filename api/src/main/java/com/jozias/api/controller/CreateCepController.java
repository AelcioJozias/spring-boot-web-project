package com.jozias.api.controller;


import com.jozias.api.documentation.CreateCepDoc;
import com.jozias.api.dtos.input.CreateCepRequest;
import com.jozias.api.dtos.output.CepResponse;
import com.jozias.api.entitiy.Cep;
import com.jozias.api.infra.config.ApiVersion;
import com.jozias.api.mapper.CepMapper;
import com.jozias.api.service.CreateCepService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = ApiVersion.V1 + "/ceps", produces = APPLICATION_JSON_VALUE)
public class CreateCepController implements CreateCepDoc {

    private final CreateCepService createCepService;

    public CreateCepController(final CreateCepService createCepService) {
        this.createCepService = createCepService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<CepResponse> create(@Valid @RequestBody CreateCepRequest createCepRequest) {
        Cep cep = createCepService.create(createCepRequest);
        CepResponse cepResponse = CepMapper.toDto(cep);
        return ResponseEntity.status(CREATED).body(cepResponse);
    }
}
