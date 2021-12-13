package com.bootcamp.bankProducts.Domain;


import lombok.Data;

@Data
public class BankCredit {
   private String id;
   private BankCreditType bankCreditType;
   private int maximNumberCredit;
   private String cardNumber;
   private int creditLimit;
   public int getMaximNumberCredit() {
      return maximNumberCredit;
   }
   public void setMaximNumberCredit(int maximNumberCredit) {
      this.maximNumberCredit = maximNumberCredit;
   } 
}
