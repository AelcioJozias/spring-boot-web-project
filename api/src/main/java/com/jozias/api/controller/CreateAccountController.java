package com.jozias.api.controller;

import com.jozias.api.documentation.CreateContaDoc;
import com.jozias.api.dtos.input.CreateAccountRequest;
import com.jozias.api.dtos.output.CreateAccountResponse;
import com.jozias.api.entitiy.Account;
import com.jozias.api.infra.config.ApiVersion;
import com.jozias.api.mapper.AccountMapper;
import com.jozias.api.service.CreateAccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = ApiVersion.V1 + "/accounts",  produces = APPLICATION_JSON_VALUE)
public class CreateAccountController implements CreateContaDoc {

    private final CreateAccountService createAccountService;

    public CreateAccountController(final CreateAccountService createAccountService) {
        this.createAccountService = createAccountService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateAccountResponse> create(@Valid @RequestBody CreateAccountRequest createAccountRequest) {
        Account account = createAccountService.criarConta(createAccountRequest);
        CreateAccountResponse accountResponse = AccountMapper.toCreateAccountResponse(account);
        return ResponseEntity.status(CREATED).body(accountResponse);
    }
}
