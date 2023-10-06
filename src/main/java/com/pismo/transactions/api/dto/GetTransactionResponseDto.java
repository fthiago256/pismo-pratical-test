package com.pismo.transactions.api.dto;

import com.pismo.transactions.Transaction;

public class GetTransactionResponseDto {

    public Long transactionId;
    public Long accountId;

    public Long operationalTypeId;

    public Double amount;

    public GetTransactionResponseDto(Transaction transaction){
        this.transactionId = transaction.getId();
        this.accountId = transaction.getAccountId();
        this.operationalTypeId = transaction.getOperationalType().getId();
        this.amount = transaction.getAmount();
    }
}
