package com.bootcamp.bankProducts.Domain;



import lombok.Data;

@Data
public class BankAccount {
    private String bankAccountId;
    private BankAccountType bankAccountType;
    private String name;
    private double commission;
    private int limitMovement;
    private double minimum_monthly_amount;
}
