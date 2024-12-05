package com.jozias.api.controller;

import com.jozias.api.documentation.SearchCepDoc;
import com.jozias.api.entitiy.Cep;
import com.jozias.api.dtos.output.CepResponse;
import com.jozias.api.infra.config.ApiVersion;
import com.jozias.api.mapper.CepMapper;
import com.jozias.api.service.SearchCepService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = ApiVersion.V1 + "/ceps", produces = APPLICATION_JSON_VALUE)
public class SearchCepController implements SearchCepDoc {

    private final SearchCepService searchCepService;

    public SearchCepController(SearchCepService searchCepService) {
        this.searchCepService = searchCepService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<CepResponse> search(@PathVariable String cep) {
        Cep CepSearched = searchCepService.search(cep);
        return ResponseEntity.status(HttpStatus.OK).body(CepMapper.toDto(CepSearched));
    }
}
