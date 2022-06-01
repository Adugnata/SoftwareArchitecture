package com.checkingaccountservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class CheckingAccountController {

    @Autowired
    private BankRepository bankRepository;

    @PostMapping("/checking/deposit/{accountNumber}")
    public ResponseEntity<?> deposit(@PathVariable String accountNumber, @RequestBody int amount) {
        try {
            bankRepository.deposit(accountNumber, amount);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("No account found", HttpStatus.OK);
        }
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @PostMapping("/checking/withdraw/{accountNumber}")
    public ResponseEntity<?> withdraw(@PathVariable String accountNumber, @RequestBody int amount) {
        try {
            bankRepository.withdraw(accountNumber, amount);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("No account found", HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>("Insufficient funds", HttpStatus.OK);
        }
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @GetMapping("/checking/balance/{accountNumber}")
    public ResponseEntity<?> balance(@PathVariable String accountNumber) {
        CheckingAccount account = bankRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            return new ResponseEntity<>("No account found", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(account.getBalance(), HttpStatus.OK);
        }
    }

    @PostMapping("/checking/account")
    public ResponseEntity<?> addAccount(@RequestBody CheckingAccount account) {
        bankRepository.save(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
