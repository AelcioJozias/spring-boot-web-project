package com.jozias.web.controller;


import com.jozias.web.infra.config.ApiVersion;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ApiVersion.V1 + "/pessoas{pessoaId}/contas", consumes = MediaType.APPLICATION_JSON_VALUE)
public class CreateAccountController {


    @PostMapping(path = "/{contaId}")
    public void criarConta() {
    }
}
