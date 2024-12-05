package com.jozias.api.controller;

import com.jozias.api.dtos.output.SearchTransactionResponse;
import com.jozias.api.entitiy.Transaction;
import com.jozias.api.infra.config.ApiVersion;
import com.jozias.api.mapper.TransactionMapper;
import com.jozias.api.service.SearchTransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = ApiVersion.V1 + "/contas/{conta}/movimentacoes")
public class PesquisarMovimentacao {


    private final SearchTransactionService searchTransactionService;

    public PesquisarMovimentacao(SearchTransactionService searchTransactionService) {
        this.searchTransactionService = searchTransactionService;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<SearchTransactionResponse> pesquisar(@PathVariable String conta) {
        final List<Transaction> transactions = searchTransactionService.search(conta);
        return TransactionMapper.toSearchTransactionResponseList(transactions);
    }


}
