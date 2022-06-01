package com.bankclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class BankClientApplication implements CommandLineRunner {

    @Autowired
    private RestOperations restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(BankClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String checkingUrl = "http://localhost:8082/checking/";
        String savingUrl = "http://localhost:8081/saving/";
        String orchestratorUrl = "http://localhost:8080/transfer/";

        Account checkingAccount = new Account("abc", 400);
        Account savingAccount = new Account("xyz", 320);

        // add checkingAccount
        restTemplate.postForLocation(checkingUrl + "/account", checkingAccount);
        System.out.println(" --- adding a checking account (abc) with 400 ---");
//
//        // add savingAccount
        restTemplate.postForLocation(savingUrl + "/account", savingAccount);
        System.out.println(" --- adding a saving account (xyz) with 320 ---");

        // transfer 300 from abc to xyz
        Transaction transaction = new Transaction(checkingAccount.getAccountNumber(), savingAccount.getAccountNumber(), 300);
        String result = restTemplate.postForObject(orchestratorUrl, transaction, String.class);
        System.out.println(" ---- transferring 300 from abc to xyz ----");
        System.out.println(result);

        // add the product to a shopping cart
//        restTemplate.postForLocation(cartServerUrl + "/{cartNumber}", new CartLine(2, coolHat), "9009");
//        System.out.println("---- added the product to the shopping cart -----");

        // get the new checking (abc) balance
        Integer checkingBalance = restTemplate.getForObject(checkingUrl + "/balance/{accountNumber}", Integer.class, checkingAccount.getAccountNumber());
        System.out.println(" ---- getting the new checking (abc) balance ----");
        System.out.println(checkingBalance);

        // get the new saving (xyz) balance
        Integer savingBalance = restTemplate.getForObject(savingUrl + "/balance/{accountNumber}", Integer.class, savingAccount.getAccountNumber());
        System.out.println(" ---- getting the new saving (xyz) balance ----");
        System.out.println(savingBalance);

        // transfer 500 from abc to xyz
        Transaction transactionLarge = new Transaction(checkingAccount.getAccountNumber(), savingAccount.getAccountNumber(), 300);
        String resultInsufficient = restTemplate.postForObject(orchestratorUrl, transactionLarge, String.class);
        System.out.println(" ---- transferring 500 from abc to xyz (**insufficient funds) ----");
        System.out.println(resultInsufficient);

        // get the new checking (abc) balance
        Integer checkingBalance2 = restTemplate.getForObject(checkingUrl + "/balance/{accountNumber}", Integer.class, checkingAccount.getAccountNumber());
        System.out.println(" ---- getting the new checking (abc) balance ----");
        System.out.println(checkingBalance2);

        // get the new saving (xyz) balance
        Integer savingBalance2 = restTemplate.getForObject(savingUrl + "/balance/{accountNumber}", Integer.class, savingAccount.getAccountNumber());
        System.out.println(" ---- getting the new saving (xyz) balance ----");
        System.out.println(savingBalance2);

        // transfer 50 from abc to an invalid account
        Transaction transactionInvalidSaving = new Transaction(checkingAccount.getAccountNumber(), "invalid", 50);
        String resultInvalidSaving = restTemplate.postForObject(orchestratorUrl, transactionInvalidSaving, String.class);
        System.out.println(" ---- transfer 50 from abc to an invalid account ----");
        System.out.println(resultInvalidSaving);

        // get the new checking (abc) balance
        Integer checkingBalanceAfterInvalid = restTemplate.getForObject(checkingUrl + "/balance/{accountNumber}", Integer.class, checkingAccount.getAccountNumber());
        System.out.println(" ---- getting the new checking (abc) balance (should not change) ----");
        System.out.println(checkingBalanceAfterInvalid);
    }

    @Bean
    RestOperations restTemplate() {
        return new RestTemplate();
    }
}
