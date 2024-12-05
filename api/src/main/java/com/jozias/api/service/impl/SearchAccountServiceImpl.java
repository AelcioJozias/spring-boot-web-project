package com.jozias.api.service.impl;

import com.jozias.api.entitiy.Account;
import com.jozias.api.repository.AccountRepository;
import com.jozias.api.service.SearchAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchAccountServiceImpl implements SearchAccountService {

    private final AccountRepository accountRepository;

    public SearchAccountServiceImpl(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;

    }

    @Override
    public List<Account> search(final String cpf) {
        return accountRepository.findAllByCpfWithTransactions(cpf);
    }
}
