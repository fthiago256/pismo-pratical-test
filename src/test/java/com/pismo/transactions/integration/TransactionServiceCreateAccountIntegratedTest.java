package com.pismo.transactions.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pismo.accounts.Account;
import com.pismo.accounts.AccountRepository;
import com.pismo.accounts.AccountService;
import com.pismo.accounts.api.dto.CreateAccountRequestDto;
import com.pismo.transactions.Transaction;
import com.pismo.transactions.TransactionRepository;
import com.pismo.transactions.api.dto.CreateTransactionRequestDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionServiceCreateAccountIntegratedTest {

    private final String documentNumber = "112343423";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    public void before() {
        this.createAccount();
    }

    @Test
    void createTransactionWithNegativeValueTest() throws Exception {
        CreateTransactionRequestDto createTransactionDto = new CreateTransactionRequestDto();
        createTransactionDto.accountId = 1L;
        createTransactionDto.operationalTypeId = 3L;
        createTransactionDto.amount = 400.10;

        MvcResult result = mockMvc.perform(post("/v1/transactions")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(createTransactionDto)))
                .andExpect(status().isCreated()).andReturn();

        final String transactionId = result.getResponse().getContentAsString();

        final Transaction transaction = repository.findById(Long.valueOf(transactionId)).get();

        assertThat(transaction.getAccountId()).isEqualTo(createTransactionDto.accountId);
        assertThat(transaction.getAmount()).isEqualTo(createTransactionDto.amount * -1);
    }

    private void createAccount() {
        CreateAccountRequestDto dto = new CreateAccountRequestDto();
        dto.documentNumber = this.documentNumber;
        accountService.create(dto);
    }
}
