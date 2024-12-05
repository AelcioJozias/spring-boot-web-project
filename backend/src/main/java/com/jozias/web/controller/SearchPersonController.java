package com.jozias.web.controller;


import com.jozias.web.dto.output.ResumedPersonResponse;
import com.jozias.web.dto.output.PersonResponse;
import com.jozias.web.entity.Person;
import com.jozias.web.infra.config.ApiVersion;
import com.jozias.web.mapper.PerssonMapper;
import com.jozias.web.service.SearchPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = ApiVersion.V1 + "/pessoas", consumes = MediaType.APPLICATION_JSON_VALUE)
public class SearchPersonController {

    private final SearchPersonService searchPersonService;

    public SearchPersonController(SearchPersonService searchPersonService) {
        this.searchPersonService = searchPersonService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonResponse> pesquisar() {
        final List<Person> people = searchPersonService.pesquisarTodasAsPessoas();
        return people.stream().map(PerssonMapper::toPessoaResponse).toList();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/resumo",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ResumedPersonResponse> pesquisarNomeEDocumento() {
        final List<Person> people = searchPersonService.pesquisarTodasAsPessoas();
        return people.stream().map(PerssonMapper::toPessoaResumo).toList();
    }

}
