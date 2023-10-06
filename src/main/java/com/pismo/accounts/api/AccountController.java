package com.pismo.accounts.api;

import com.pismo.accounts.Account;
import com.pismo.accounts.AccountService;

import com.pismo.accounts.api.dto.CreateAccountRequestDto;
import com.pismo.accounts.api.dto.GetAccountResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    private final AccountService accountService;
    private final Logger logger = LoggerFactory.getLogger(AccountService.class);

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetAccountResponseDto> getById(@PathVariable("id") String id) {
        Account account = this.accountService.getById(Long.valueOf(id)).get();
        logger.info("Account: ", account);
        return ResponseEntity.ok(new GetAccountResponseDto(account));
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody CreateAccountRequestDto createAccountRequestDto) {
        this.accountService.create(createAccountRequestDto);
        logger.info("Account created: ", createAccountRequestDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }


}