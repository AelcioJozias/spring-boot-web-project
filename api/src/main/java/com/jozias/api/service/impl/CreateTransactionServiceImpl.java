package com.jozias.api.service.impl;

import com.jozias.api.dtos.input.CreateTransactionRequest;
import com.jozias.api.entitiy.Account;
import com.jozias.api.entitiy.Transaction;
import com.jozias.api.entitiy.TransactionType;
import com.jozias.api.exception.AccountNotFoundException;
import com.jozias.api.repository.AccountRepository;
import com.jozias.api.service.CreateTransactionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionServiceImpl implements CreateTransactionService {

    private final AccountRepository accountRepository;

    public CreateTransactionServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    @Override
    public Transaction createTransaction(CreateTransactionRequest createTransactionRequest) {
        Account account = getAccount(createTransactionRequest);
        Transaction transaction = getTransaction(createTransactionRequest, account);
        account.addTransaction(transaction);
        accountRepository.save(account);
        return transaction;
    }

    private static Transaction getTransaction(final CreateTransactionRequest createTransactionRequest, final Account account) {
        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.valueOf(createTransactionRequest.transactionType()));
        transaction.setAccount(account);
        transaction.setValue(createTransactionRequest.value());
        return transaction;
    }

    private Account getAccount(final CreateTransactionRequest createTransactionRequest) {
        return accountRepository.findByConta(createTransactionRequest.account()).orElseThrow(() -> new AccountNotFoundException(String.format("Não existe uma account com o id %s", createTransactionRequest.account())));
    }
}
