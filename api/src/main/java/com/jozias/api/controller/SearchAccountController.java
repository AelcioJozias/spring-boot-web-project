package com.jozias.api.controller;

import com.jozias.api.dtos.output.SearchAccountResponse;
import com.jozias.api.entitiy.Account;
import com.jozias.api.infra.config.ApiVersion;
import com.jozias.api.mapper.AccountMapper;
import com.jozias.api.service.SearchAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = ApiVersion.V1 + "/accounts")
public class SearchAccountController {

    private final SearchAccountService searchAccountService;

    public SearchAccountController(SearchAccountService searchAccountService) {
        this.searchAccountService = searchAccountService;
    }

    @GetMapping(value = "/{cpf}", produces = APPLICATION_JSON_VALUE)
    public List<SearchAccountResponse> pesquisar(@PathVariable String cpf) {
        final List<Account> accounts = searchAccountService.search(cpf);
        return AccountMapper.toSearchAccountResponse(accounts);
    }

}
