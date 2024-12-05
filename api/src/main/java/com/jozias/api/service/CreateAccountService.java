package com.jozias.api.service;

import com.jozias.api.dtos.input.CreateAccountRequest;
import com.jozias.api.entitiy.Account;

public interface CreateAccountService {
    Account criarConta(CreateAccountRequest createAccountRequest);
}
