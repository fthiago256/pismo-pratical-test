package com.pismo.accounts.api.dto;

import com.pismo.accounts.Account;

public class CreateAccountRequestDto {

    public String documentNumber;

    public Account toAccount() {
        return new Account(this.documentNumber);
    }
}
