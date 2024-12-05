package com.jozias.api.repository;

import com.jozias.api.entitiy.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findAllByAccount_Account(String account);
}
