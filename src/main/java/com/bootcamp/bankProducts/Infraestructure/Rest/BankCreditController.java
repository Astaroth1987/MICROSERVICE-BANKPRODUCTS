package com.bootcamp.bankProducts.Infraestructure.Rest;

import com.bootcamp.bankProducts.Application.BankCreditOperations;
import com.bootcamp.bankProducts.Domain.BankCredit;

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
@RequestMapping("/BankCredit")
@RequiredArgsConstructor
public class BankCreditController {
private final BankCreditOperations bankCreditOperations;

@GetMapping("/getAll")
public Flux<BankCredit> getAll(){
    return bankCreditOperations.findAll();
}
@GetMapping("/getById/{id}")
public Mono<BankCredit> getById(@PathVariable String id){
    return bankCreditOperations.findById(id);
}
@PostMapping("/Create")
public Mono<BankCredit> post(@RequestBody BankCredit credit){
    return bankCreditOperations.create(credit);
}
@PutMapping("/Update/{id}")
public Mono<BankCredit> put(@PathVariable String id, @RequestBody BankCredit credit){
    return bankCreditOperations.update(id, credit);
}
@DeleteMapping("Delete/{id}")
public  void delete(@PathVariable String id){
    bankCreditOperations.delete(id);
}
}
