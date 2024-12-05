package com.jozias.web.controller;

import com.jozias.web.dto.input.PersonRequest;
import com.jozias.web.infra.config.ApiVersion;
import com.jozias.web.service.UpdatePersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path =ApiVersion.V1 + "/pessoas", consumes = MediaType.APPLICATION_JSON_VALUE)
public class UpdatePersonController {

    private final UpdatePersonService updatePersonService;

    public UpdatePersonController(UpdatePersonService updatePersonService) {
        this.updatePersonService = updatePersonService;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "/{pessoaId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void atualizarPessoa(@RequestBody PersonRequest personRequest, @PathVariable("pessoaId") final Long id) {
        updatePersonService.atualizar(personRequest, id);
    }
}
