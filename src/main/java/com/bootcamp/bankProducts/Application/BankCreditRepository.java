package com.bootcamp.bankProducts.Application;

import com.bootcamp.bankProducts.Domain.BankCredit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankCreditRepository {
     Mono<BankCredit> create(BankCredit bankCredit);
     Mono<BankCredit> update(String id, BankCredit bankCredit);
     void delete(String id);
     Mono<BankCredit> findById(String id);
     Flux<BankCredit> findAll();
}
