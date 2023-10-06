package com.pismo.accounts.unit;

import com.pismo.accounts.Account;
import com.pismo.accounts.AccountRepository;
import com.pismo.accounts.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountServiceTest {
    final String documentNumber = "999999999";
    final Long accountId = 1L;

    @Autowired
    private AccountService accountService;
    @MockBean
    private AccountRepository accountRepository;

    @BeforeEach
    public void setUp() {
        Account account = new Account(documentNumber);
        Mockito.when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));
    }

    @Test
    public void shouldReturnAccountByGivenId() {
        //Given

        //When
        Account account = accountService.getById(accountId).get();

        //Then
        assertEquals(account.getDocumentNumber(), documentNumber);

    }
}
