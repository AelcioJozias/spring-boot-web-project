package com.jozias.api.service.impl;

import com.jozias.api.repository.AccountRepository;
import com.jozias.api.service.DeleteAccountService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DeleteAccountServiceImpl implements DeleteAccountService {

    private final AccountRepository accountRepository;

    public DeleteAccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    @Override
    public void delete(final String account) {
        accountRepository.deleteAccountByAccount(account);
    }
}
