package com.bootcamp.bankProducts.Application;

import com.bootcamp.bankProducts.Domain.BankCredit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankCreditOperationsImpl implements BankCreditOperations {
    @Autowired
    BankCreditRepository repository;

    @Override
    public Mono<BankCredit> create(BankCredit bankCredit) {
    
        return repository.create(bankCredit);
    }

    @Override
    public Mono<BankCredit> update(String id, BankCredit bankCredit) {
    
        return repository.update(id, bankCredit);
    }

    @Override
    public void delete(String id) {
    repository.delete(id);
        
    }

    @Override
    public Mono<BankCredit> findById(String id) {
    
        return repository.findById(id);
    }

    @Override
    public Flux<BankCredit> findAll() {
    
        return repository.findAll();
    }
    
}
