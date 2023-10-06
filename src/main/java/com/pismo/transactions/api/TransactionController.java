package com.pismo.transactions.api;

import com.pismo.accounts.AccountService;
import com.pismo.transactions.Transaction;
import com.pismo.transactions.TransactionService;
import com.pismo.transactions.api.dto.CreateTransactionRequestDto;
import com.pismo.transactions.api.dto.GetTransactionResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final Logger logger = LoggerFactory.getLogger(AccountService.class);

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetTransactionResponseDto> getById(@PathVariable("id") String id) {
        Transaction transaction = this.transactionService.getById(Long.valueOf(id)).get();
        logger.info("Transaction: ", transaction);
        return ResponseEntity.ok(new GetTransactionResponseDto(transaction));
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody CreateTransactionRequestDto createTransactionRequestDto) {
        Long transactionId = this.transactionService.create(createTransactionRequestDto);
        logger.info("Transaction created: ", createTransactionRequestDto);
        return new ResponseEntity(transactionId, HttpStatus.CREATED);
    }


}