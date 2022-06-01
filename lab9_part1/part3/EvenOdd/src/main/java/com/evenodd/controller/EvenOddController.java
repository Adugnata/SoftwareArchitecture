package com.evenodd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvenOddController {

    @GetMapping("/validate")
    public String isNumberEvenOrOdd(@RequestParam("number1") String number1, @RequestParam("number2") String number2) {
        return Integer.parseInt(number1) % 2 == 0 && Integer.parseInt(number2) % 2 == 0 ? "Even" : "Odd";
    }
}
