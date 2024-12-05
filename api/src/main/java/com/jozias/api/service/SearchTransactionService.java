package com.jozias.api.service;

import com.jozias.api.entitiy.Transaction;

import java.util.List;

public interface SearchTransactionService {
    List<Transaction> search(String conta);
}
