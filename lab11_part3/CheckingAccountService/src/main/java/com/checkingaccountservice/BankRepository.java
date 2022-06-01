package com.checkingaccountservice;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Repository
public class BankRepository {

    private Map<String, CheckingAccount> bank = new HashMap<>();

    public void save(CheckingAccount account){
        bank.put(account.getAccountNumber(), account);
    }

    public CheckingAccount findByAccountNumber(String accountNumber){
        return bank.get(accountNumber);
    }

    public void delete(String accountNumber){
        bank.remove(accountNumber);
    }

    public void withdraw(String accountNumber, int amount) throws NoSuchElementException, IllegalStateException {
        CheckingAccount account = findByAccountNumber(accountNumber);
        if (account == null) {
            throw new NoSuchElementException();
        }
        if (amount > account.getBalance()) {
            throw new IllegalStateException();
        }
        account.setBalance(account.getBalance() - amount);
        save(account);
    }

    public void deposit(String accountNumber, int amount) throws NoSuchElementException {
        CheckingAccount account = findByAccountNumber(accountNumber);
        if (account == null) {
            throw new NoSuchElementException();
        }
        account.setBalance(account.getBalance() + amount);
        save(account);
    }

    public Collection<CheckingAccount> findAll(){
        return bank.values();
    }
}
