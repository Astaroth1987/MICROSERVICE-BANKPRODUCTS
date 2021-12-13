package com.bootcamp.bankProducts.Application;

import com.bootcamp.bankProducts.Domain.BankAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class BankAccountOperationsImpl implements BankAccountOperations {

@Autowired
BankAccountRepository repository;

    @Override
    public Mono<BankAccount> create(BankAccount bankAccount) {
        
        return repository.create(bankAccount);
    }

    @Override
    public Mono<BankAccount> update(String bankAccountId, BankAccount bankAccount) {
        
        return repository.update(bankAccountId, bankAccount);
    }

    @Override
    public void delete(String bankAccountId) {
        repository.delete(bankAccountId);
        
    }

    @Override
    public Mono<BankAccount> findById(String bankAccountId) {
        
        return repository.findById(bankAccountId);
    }

    @Override
    public Flux<BankAccount> findAll() {
        
        return repository.findAll();
    }
    
}
