package com.bootcamp.bankProducts.Infraestructure.Rest;

import com.bootcamp.bankProducts.Application.BankAccountOperations;
import com.bootcamp.bankProducts.Domain.BankAccount;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/BankAccount")
@RequiredArgsConstructor
public class BankAccountController {
    private final BankAccountOperations bankAccountOperations;

    @GetMapping("/getAll")
    public Flux<BankAccount> getAll(){
        return bankAccountOperations.findAll();
    }
    @GetMapping("/getById/{bankAccountId}")
    public Mono<BankAccount> getById(@PathVariable String bankAccountId){
        return bankAccountOperations.findById(bankAccountId);
    }
    @PostMapping("/Create")
    public Mono<BankAccount> post(@RequestBody BankAccount bankAccount){
        return bankAccountOperations.create(bankAccount);
    }
    @PutMapping("/Update/{bankAccountId}")
    public Mono<BankAccount> put(@PathVariable String bankAccountId, @RequestBody BankAccount bankAccount){
        return bankAccountOperations.update(bankAccountId, bankAccount);
    }
    @DeleteMapping("Delete/{bankAccountId}")
    public  void delete(@PathVariable String bankAccountId){
        bankAccountOperations.delete(bankAccountId);
    }

}
