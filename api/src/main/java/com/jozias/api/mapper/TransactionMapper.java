package com.jozias.api.mapper;

import com.jozias.api.dtos.output.CreateTransactionResponse;
import com.jozias.api.dtos.output.SearchTransactionResponse;
import com.jozias.api.entitiy.Transaction;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class TransactionMapper {

    public static SearchTransactionResponse toSearchTransactionResponse(final Transaction transaction) {
        return new SearchTransactionResponse(transaction.getTransactionDate(), transaction.getTransactionValue());
    }

    public static List<SearchTransactionResponse> toSearchTransactionResponseList(final List<Transaction> transactions) {
        return transactions.stream()
                .map(TransactionMapper::toSearchTransactionResponse)
                .toList();
    }

    public static CreateTransactionResponse toTransactionResponse(final Transaction transaction) {
        return new CreateTransactionResponse(transaction.getTransactionDate(), transaction.getAccount().getAccount(), transaction.getTransactionType().name(), transaction.getTransactionValue());
    }
}
