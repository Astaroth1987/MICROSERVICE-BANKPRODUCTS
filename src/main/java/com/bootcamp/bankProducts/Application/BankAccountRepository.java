package com.bootcamp.bankProducts.Application;

import com.bootcamp.bankProducts.Domain.BankAccount;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankAccountRepository {
     Mono<BankAccount> create(BankAccount bankAccount);
     Mono<BankAccount> update(String bankAccountId, BankAccount bankAccount);
     void delete(String bankAccountId);
     Mono<BankAccount> findById(String bankAccountId);
     Flux<BankAccount> findAll();
}
