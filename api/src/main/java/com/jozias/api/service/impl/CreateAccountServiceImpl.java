package com.jozias.api.service.impl;

import com.jozias.api.dtos.input.CreateAccountRequest;
import com.jozias.api.entitiy.Account;
import com.jozias.api.exception.AccountAlreadySavedException;
import com.jozias.api.mapper.AccountMapper;
import com.jozias.api.repository.AccountRepository;
import com.jozias.api.service.CreateAccountService;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountServiceImpl implements CreateAccountService {

    private final AccountRepository accountRepository;

    public CreateAccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account criarConta(CreateAccountRequest createAccountRequest) {
        validAccountUniqueness(createAccountRequest.account());
        return accountRepository.save(AccountMapper.toEntity(createAccountRequest));
    }

    private void validAccountUniqueness(final String accountNumber) {
        accountRepository.findByConta(accountNumber)
                .ifPresent(account -> {
                    throw new AccountAlreadySavedException("Conta já cadastrada");
                });
    }

}
