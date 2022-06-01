package com.shippingservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShippingController {

    @PostMapping("/orders/normal_shipping")
    public ResponseEntity<?> receiveNormalShippingOrder(@RequestBody Order order) {
        System.out.println("Shipping Application receiving normal shipping order: "+order);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @PostMapping("/orders/next_day_shipping")
    public ResponseEntity<?> receiveNextDayShippingOrder(@RequestBody Order order) {
        System.out.println("Shipping Application receiving next day shipping order: "+order);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @PostMapping("/orders/international_shipping")
    public ResponseEntity<?> receiveInternationalShippingOrder(@RequestBody Order order) {
        System.out.println("Shipping Application receiving international shipping order: "+order);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
}
