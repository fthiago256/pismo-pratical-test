package com.pismo.transactions;

import com.pismo.accounts.Account;
import com.pismo.accounts.AccountService;
import com.pismo.operationaltypes.OperationalType;
import com.pismo.operationaltypes.OperationalTypeService;
import com.pismo.transactions.api.dto.CreateTransactionRequestDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final AccountService accountService;

    private final OperationalTypeService operationalTypeService;

    public TransactionService(TransactionRepository transactionRepository, AccountService accountService, OperationalTypeService operationalTypeService) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
        this.operationalTypeService = operationalTypeService;
    }

    public Optional<Transaction> getById(final Long id) {
        return this.transactionRepository.findById(id);
    }

    public Long create(final CreateTransactionRequestDto createTransactionRequestDto) {
        final Account account = this.findAccount(createTransactionRequestDto.accountId);
        final OperationalType operationalType = this.findOperationalType(createTransactionRequestDto.operationalTypeId);

        Transaction transaction = new Transaction();
        transaction.setOperationalType(operationalType);
        transaction.setAccountId(account.getId());
        transaction.setAmount(operationalType.calculateAmount(createTransactionRequestDto.amount));
        return this.transactionRepository.saveAndFlush(transaction).getId();
    }

    private Account findAccount(Long accountId) {
       return this.accountService.getById(accountId).orElseThrow();
    }

    private OperationalType findOperationalType(Long accountId) {
        return this.operationalTypeService.getById(accountId).orElseThrow();
    }
}
