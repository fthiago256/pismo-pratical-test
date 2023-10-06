package com.pismo.transactions.api.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateTransactionRequestDto {

    @JsonProperty("account_id")
    public Long accountId;


    @JsonProperty("operation_type_id")
    public Long operationalTypeId;

    @JsonProperty("amount")
    public Double amount;
}
