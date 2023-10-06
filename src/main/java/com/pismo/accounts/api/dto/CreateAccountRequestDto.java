package com.pismo.accounts.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pismo.accounts.Account;

public class CreateAccountRequestDto {

    @JsonProperty("document_number")
    public String documentNumber;

    public Account toAccount() {
        return new Account(this.documentNumber);
    }
}
