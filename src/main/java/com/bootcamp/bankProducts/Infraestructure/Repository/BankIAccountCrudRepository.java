package com.bootcamp.bankProducts.Infraestructure.Repository;

import com.bootcamp.bankProducts.Infraestructure.Model.Dao.BankAccountDao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BankIAccountCrudRepository extends ReactiveCrudRepository<BankAccountDao,String> {
    
    
}
