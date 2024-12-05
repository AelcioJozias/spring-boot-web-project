package com.jozias.api.service.impl;

import com.jozias.api.entitiy.Transaction;
import com.jozias.api.repository.TransactionRepository;
import com.jozias.api.service.SearchTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchTransactionServiceImpl implements SearchTransactionService {

    private final TransactionRepository transactionRepository;

    public SearchTransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> search(String account) {
        return transactionRepository.findAllByAccount_Account(account);
    }
}
