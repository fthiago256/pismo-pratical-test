package com.pismo.transactions.api.dto;

import com.pismo.accounts.Account;
import com.pismo.transactions.Transaction;

public class CreateTransactionRequestDto {

    public Long accountId;

    public Long operationalTypeId;

    public Double amount;
}
