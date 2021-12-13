package com.bootcamp.bankProducts.Infraestructure.Repository;

import com.bootcamp.bankProducts.Application.BankAccountRepository;
import com.bootcamp.bankProducts.Domain.BankAccount;
import com.bootcamp.bankProducts.Infraestructure.Model.Dao.BankAccountDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class BankAccountCrudRepository implements BankAccountRepository {
    @Autowired
    BankIAccountCrudRepository repository;

    @Override
    public Mono<BankAccount> create(BankAccount bankAccount) {
    
        return repository.save(mapAccountToAccountDao(bankAccount))
        .map(this::mapAccountDaoToAccount);
    }

    @Override
    public Mono<BankAccount> update(String bankAccountId, BankAccount bankAccount) {
    bankAccount.setBankAccountId(bankAccountId);
    return repository.save(mapAccountToAccountDao(bankAccount))
    .map(this::mapAccountDaoToAccount);
     
    }

    @Override
    public void delete(String bankAccountId) {
    repository.deleteById(bankAccountId).subscribe();
        
    }

    @Override
    public Mono<BankAccount> findById(String bankAccountId) {
    
        return repository.findById(bankAccountId)
        .map(this::mapAccountDaoToAccount);
    }

    @Override
    public Flux<BankAccount> findAll() {
    
        return repository.findAll().map(this::mapAccountDaoToAccount);
    }

    private BankAccountDao mapAccountToAccountDao (BankAccount bankAccount){
        BankAccountDao bankAccountDao = new BankAccountDao();
       bankAccountDao.setBankAccountId(bankAccount.getBankAccountId());
       bankAccountDao.setBankAccountType(bankAccount.getBankAccountType());
       bankAccountDao.setName(bankAccount.getName());
       bankAccountDao.setCommission(bankAccount.getCommission());
       bankAccountDao.setLimitMovement(bankAccount.getLimitMovement());
        return bankAccountDao;
    }
   
    private BankAccount mapAccountDaoToAccount (BankAccountDao bankAccountDao){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankAccountId(bankAccountDao.getBankAccountId());
        bankAccount.setBankAccountType(bankAccountDao.getBankAccountType());
        bankAccount.setName(bankAccountDao.getName());
        bankAccount.setCommission(bankAccountDao.getCommission());
        bankAccount.setLimitMovement(bankAccountDao.getLimitMovement());
        return bankAccount;
    }
    
}
