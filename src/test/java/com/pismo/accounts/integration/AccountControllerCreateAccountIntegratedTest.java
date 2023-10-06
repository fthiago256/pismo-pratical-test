package com.pismo.accounts.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pismo.accounts.Account;
import com.pismo.accounts.AccountRepository;
import com.pismo.accounts.api.dto.CreateAccountRequestDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerCreateAccountIntegratedTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    public void before() {
        this.truncateTable();
    }

    @Test
    @Disabled
    void accountCreationTest() throws Exception {
        final String documentNumber = "12345678900";
        CreateAccountRequestDto createAccountRequestDto = new CreateAccountRequestDto();

        createAccountRequestDto.documentNumber = documentNumber;

        mockMvc.perform(post("/v1/accounts")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(createAccountRequestDto)))
                .andExpect(status().isCreated());

        Account account = accountRepository.findByDocumentNumber(documentNumber);

        assertThat(account.getDocumentNumber()).isEqualTo(documentNumber);
    }

    private void truncateTable(){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Account> query = builder.createCriteriaDelete(Account.class);
        query.from(Account.class);
        entityManager.createQuery(query).executeUpdate();
    }


}
