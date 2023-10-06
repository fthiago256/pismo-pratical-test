package com.pismo.accounts;

import com.pismo.accounts.api.dto.CreateAccountRequestDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Optional<Account> getById(final Long id) {
        return this.accountRepository.findById(id);
    }

    public void create(final CreateAccountRequestDto createAccountRequestDto) {
        this.accountRepository.saveAndFlush(createAccountRequestDto.toAccount());
    }
}
