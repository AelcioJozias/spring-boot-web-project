package com.jozias.api.mapper;

import com.jozias.api.dtos.input.CreateAccountRequest;
import com.jozias.api.dtos.output.CreateAccountResponse;
import com.jozias.api.dtos.output.SearchAccountResponse;
import com.jozias.api.entitiy.Account;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

import java.util.List;

@UtilityClass
public class AccountMapper {

        public static Account toEntity(final CreateAccountRequest createAccountRequest) {
            Account account = new Account();
            BeanUtils.copyProperties(createAccountRequest, account);
            return account;
        }

        public static CreateAccountResponse toCreateAccountResponse(final Account account) {
            return new CreateAccountResponse(account.getId(), account.getCpf(), account.getAccount());
        }

        public static SearchAccountResponse toSearchAccountResponse(final Account account) {
            return new SearchAccountResponse(account.getAccount(), account.getCreatedAt(), account.getCurrentTotalBalance());
        }

        public static List<SearchAccountResponse> toSearchAccountResponse(final List<Account> accounts) {
            return accounts.stream().map(AccountMapper::toSearchAccountResponse).toList();
        }

}
