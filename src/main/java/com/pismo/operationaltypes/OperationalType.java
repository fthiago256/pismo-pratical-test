package com.pismo.operationaltypes;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class OperationalType {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    @Transient
    private List<Long> positiveOperationalTypes = List.of(4L);


    public boolean isOperationalTypePositive() {
        return positiveOperationalTypes.contains(this.id);
    }

    public Double calculateAmount(Double amount) {
        if(!isOperationalTypePositive()) {
            return amount * -1L;
        }
        return amount;
    }
}
