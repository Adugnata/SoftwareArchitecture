package com.savingaccountservice;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Repository
public class BankRepository {

    private Map<String, SavingAccount> bank = new HashMap<>();

    public void save(SavingAccount account){
        bank.put(account.getAccountNumber(), account);
    }

    public SavingAccount findByAccountNumber(String accountNumber){
        return bank.get(accountNumber);
    }

    public void delete(String accountNumber){
        bank.remove(accountNumber);
    }

    public void withdraw(String accountNumber, int amount) throws NoSuchElementException, IllegalStateException {
        SavingAccount account = findByAccountNumber(accountNumber);
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
        SavingAccount account = findByAccountNumber(accountNumber);
        if (account == null) {
            throw new NoSuchElementException();
        }
        account.setBalance(account.getBalance() + amount);
        save(account);
    }

    public Collection<SavingAccount> findAll(){
        return bank.values();
    }
}
