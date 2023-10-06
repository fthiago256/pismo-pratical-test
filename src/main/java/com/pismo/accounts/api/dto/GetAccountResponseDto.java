package com.pismo.accounts.api.dto;

import com.pismo.accounts.Account;

public class GetAccountResponseDto {

    public Long id;

    public String documentNumber;

    public GetAccountResponseDto(Account account){
        this.id = account.getId();
        this.documentNumber = account.getDocumentNumber();

    }
}
