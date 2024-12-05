package com.jozias.api.service;

import com.jozias.api.dtos.input.CreateTransactionRequest;
import com.jozias.api.entitiy.Transaction;

public interface CreateTransactionService {
    Transaction createTransaction(CreateTransactionRequest request);
}
