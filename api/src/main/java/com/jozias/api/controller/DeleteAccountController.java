package com.jozias.api.controller;

import com.jozias.api.infra.config.ApiVersion;
import com.jozias.api.service.DeleteAccountService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = ApiVersion.V1 + "/accounts", produces = APPLICATION_JSON_VALUE)
public class DeleteAccountController {

    private final DeleteAccountService deleteAccountService;

    public DeleteAccountController(DeleteAccountService deleteAccountService) {
        this.deleteAccountService = deleteAccountService;
    }

    @DeleteMapping(path = "/{account}")
    @ResponseStatus(NO_CONTENT)
    public void excluir(@PathVariable String account) {
        deleteAccountService.delete(account);
    }
}
