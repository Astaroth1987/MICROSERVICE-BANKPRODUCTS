package com.bootcamp.bankProducts.Infraestructure.Repository;

import com.bootcamp.bankProducts.Infraestructure.Model.Dao.BankCreditDao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BankICreditCrudRepository extends ReactiveCrudRepository<BankCreditDao, String> {
    
}
