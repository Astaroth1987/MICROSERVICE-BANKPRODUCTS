package com.bootcamp.bankProducts.Infraestructure.Model.Dao;

import com.bootcamp.bankProducts.Domain.BankCreditType;

//import com.example.bankProducts.Domain.BankCreditType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;



@Document("bankCredits")
@Data
public class BankCreditDao {
    @Id
    private String id;
    private BankCreditType bankCreditType;
    private int maximumNumberCredit;
    private String cardNumber;
    private int creditLimit;
    public int getMaximumNumberCredit() {
        return maximumNumberCredit;
    }
    public void setMaximumNumberCredit(int maximumNumberCredit) {
        this.maximumNumberCredit = maximumNumberCredit;
    }
}
