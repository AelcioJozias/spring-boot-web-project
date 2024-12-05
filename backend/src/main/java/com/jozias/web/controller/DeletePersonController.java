package com.jozias.web.controller;

import com.jozias.web.infra.config.ApiVersion;
import com.jozias.web.service.DeletePersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ApiVersion.V1 + "/pessoas", consumes = MediaType.APPLICATION_JSON_VALUE)
public class DeletePersonController {

    private final DeletePersonService deletePersonService;

    public DeletePersonController(DeletePersonService deletePersonService) {
        this.deletePersonService = deletePersonService;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void excluir(Long id) {
    }

}
