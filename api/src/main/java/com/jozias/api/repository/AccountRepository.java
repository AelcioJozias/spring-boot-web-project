package com.jozias.api.repository;

import com.jozias.api.entitiy.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByCpf(String cpf);
    Optional<Account> findByConta(String conta);

    @Query("SELECT c FROM Account c LEFT JOIN FETCH c.transactions WHERE c.cpf = :cpf")
    List<Account> findAllByCpfWithTransactions(String cpf);

    void deleteAccountByAccount(String account);
}
