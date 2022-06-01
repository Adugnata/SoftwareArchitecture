package com.bankorchestrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrchestratorController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestBody Transaction transaction) {

        String checkingUrl = "http://localhost:8082/checking/";
        String savingUrl = "http://localhost:8081/saving/";
        if (transaction.getAmount() < 0) {
            return new ResponseEntity<>("Amount can't be negative", HttpStatus.OK);
        }

        // Transfer from checking account to savings account
        // First withdraw from the checking account
        String withdrawResult = restTemplate.postForObject(checkingUrl + "withdraw/{accountNumber}", transaction.getAmount(), String.class, transaction.getFromAccount());
        if (withdrawResult.equals("No account found")) {
            return new ResponseEntity<>("Transaction failed: Account: " + transaction.getFromAccount() + " not found", HttpStatus.OK);
        } else if (withdrawResult.equals("Insufficient funds")) {
            return new ResponseEntity<>("Transaction failed: Insufficient funds in account: " + transaction.getFromAccount(), HttpStatus.OK);
        } else {
            // Then deposit to the savings account
            String depositResult = restTemplate.postForObject(savingUrl + "deposit/{accountNumber}", transaction.getAmount(), String.class, transaction.getToAccount());
            if (depositResult.equals("No account found")) {
                // Refund the money back the checking account
                restTemplate.postForObject(checkingUrl + "deposit/{accountNumber}", transaction.getAmount(), String.class, transaction.getFromAccount());
                return new ResponseEntity<>("Transaction failed: Account: " + transaction.getToAccount() + " not found", HttpStatus.OK);
            } else {
                // Transaction was successful
                return new ResponseEntity<>("Transaction successful", HttpStatus.OK);
            }
        }
    }
}
