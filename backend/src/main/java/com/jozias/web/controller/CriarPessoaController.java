package com.jozias.web.controller;

import com.jozias.web.dto.input.PersonRequest;
import com.jozias.web.infra.config.ApiVersion;
import com.jozias.web.service.CriarPessoaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiVersion.V1 + "/pessoas")
public class CriarPessoaController {
    private final CriarPessoaService criarPessoaService;


    public CriarPessoaController(CriarPessoaService criarPessoaService) {
        this.criarPessoaService = criarPessoaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody @Valid PersonRequest personRequest) {
        criarPessoaService.criar(personRequest);
    }
}
