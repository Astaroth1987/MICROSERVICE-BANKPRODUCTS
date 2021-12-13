package com.bootcamp.bankProducts.Infraestructure.Model.Dao;




import com.bootcamp.bankProducts.Domain.BankAccountType;

import org.springframework.data.annotation.Id;

//import com.example.bankProducts.Domain.BankAccountType;


import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Document("bankAccounts")
@Data

public class BankAccountDao {
    @Id
    private String bankAccountId;
    private BankAccountType bankAccountType;
    private String name;
    private double commission;
    private int limitMovement;
   
}
