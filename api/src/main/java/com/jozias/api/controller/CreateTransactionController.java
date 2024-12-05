package com.jozias.api.controller;

import com.jozias.api.dtos.input.CreateTransactionRequest;
import com.jozias.api.dtos.output.CreateTransactionResponse;
import com.jozias.api.entitiy.Transaction;
import com.jozias.api.infra.config.ApiVersion;
import com.jozias.api.mapper.TransactionMapper;
import com.jozias.api.service.CreateTransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = ApiVersion.V1 + "/transactions", produces = APPLICATION_JSON_VALUE)
public class CreateTransactionController {

    private final CreateTransactionService createTransactionService;

    public CreateTransactionController(final CreateTransactionService createTransactionService) {
        this.createTransactionService = createTransactionService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CreateTransactionResponse create(@RequestBody CreateTransactionRequest request) {
        Transaction transaction = createTransactionService.createTransaction(request);
        return TransactionMapper.toTransactionResponse(transaction);
    }
}
