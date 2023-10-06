package com.pismo.transactions;

import com.pismo.operationaltypes.OperationalType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity()
public class Transaction implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long accountId;

    @ManyToOne
    private OperationalType operationalType;

    private Double amount;

    private LocalDateTime eventDate = LocalDateTime.now();

    public Transaction() {}

    public Transaction(Long accountId, OperationalType operationalType, Double amount, LocalDateTime eventDate) {
        this.accountId = accountId;
        this.operationalType = operationalType;
        this.amount = amount;
        this.eventDate = eventDate;
    }

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public OperationalType getOperationalType() {
        return operationalType;
    }

    public void setOperationalType(OperationalType operationalType) {
        this.operationalType = operationalType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }
}
