package com.bootcamp.bankProducts.Infraestructure.Repository;

import com.bootcamp.bankProducts.Application.BankCreditRepository;
import com.bootcamp.bankProducts.Domain.BankCredit;
import com.bootcamp.bankProducts.Infraestructure.Model.Dao.BankCreditDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class BankCreditCrudRepository implements BankCreditRepository {
   @Autowired
   BankICreditCrudRepository repository;

@Override
public Mono<BankCredit> create(BankCredit bankCredit) {
    return repository.save(mapCreditToCreditDao(bankCredit))
    .map(this::mapCreditDaoToCredit);
}

@Override
public Mono<BankCredit> update(String id, BankCredit bankCredit) {
    bankCredit.setId(id);
    return repository.save(mapCreditToCreditDao(bankCredit))
    .map(this::mapCreditDaoToCredit);
}

@Override
public void delete(String id) {
    repository.deleteById(id).subscribe();
}

@Override
public Mono<BankCredit> findById(String id) {
    return repository.findById(id)
    .map(this::mapCreditDaoToCredit);
}

@Override
public Flux<BankCredit> findAll() {
    return repository.findAll().map(this::mapCreditDaoToCredit);
} 

private BankCreditDao mapCreditToCreditDao (BankCredit bankCredit){
    BankCreditDao bankCreditDao = new BankCreditDao();
    bankCreditDao.setCardNumber(bankCredit.getCardNumber());
    bankCreditDao.setCreditLimit(bankCredit.getCreditLimit());
    bankCreditDao.setBankCreditType(bankCredit.getBankCreditType());
    bankCreditDao.setId(bankCredit.getId());
    bankCreditDao.setMaximumNumberCredit(bankCredit.getMaximNumberCredit());
    return bankCreditDao;
}

private BankCredit mapCreditDaoToCredit (BankCreditDao bankCreditDao){
    BankCredit bankCredit = new BankCredit();
    bankCredit.setCardNumber(bankCreditDao.getCardNumber());
    bankCredit.setCreditLimit(bankCreditDao.getCreditLimit());
    bankCredit.setBankCreditType(bankCreditDao.getBankCreditType());
    bankCredit.setId(bankCreditDao.getId());
    bankCredit.setMaximNumberCredit(bankCreditDao.getMaximumNumberCredit());
    return bankCredit;
}
}
