package com.pismo.accounts;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity()
public class Account implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String documentNumber;

    public Account() {}
    public Account(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Long getId() {
        return this.id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
