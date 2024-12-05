package com.jozias.api.service;

import com.jozias.api.entitiy.Account;

import java.util.List;

public interface SearchAccountService {
    List<Account> search(String cpf);
}
