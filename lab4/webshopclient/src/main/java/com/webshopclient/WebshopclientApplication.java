package com.webshopclient;

import com.webshopclient.product.Product;
import com.webshopclient.product.Review;
import com.webshopclient.product.Stock;
import com.webshopclient.product.Supplier;
import com.webshopclient.shopping.CartLine;
import com.webshopclient.shopping.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestOperations;

import java.util.List;

@SpringBootApplication
public class WebshopclientApplication implements CommandLineRunner {

    @Autowired
    RestOperations restTemplate;


    public static void main(String[] args) {
        SpringApplication.run(WebshopclientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String productsServerUrl = "http://localhost:8080/products";
        String cartServerUrl = "http://localhost:8080/cart";

        Supplier supplier = new Supplier("123", "abc", "3456", "abc@gmail.com");
        Stock stock = new Stock(10, "777");
        List<Review> reviews = List.of(
                new Review("Great", "high quality", 5),
                new Review("Better", "good enough", 4)
        );
        Product product = new Product("123456", "Watch", 21.8, supplier, stock, reviews);

        // add product
        restTemplate.postForLocation(productsServerUrl, product);
        System.out.println(" --- adding a product ---");

        // get the product
        Product watch = restTemplate.getForObject(productsServerUrl + "/{productNumber}", Product.class, "123456");
        System.out.println(" ---- getting Watch product ----");
        System.out.println(watch);

        // add the product to a shopping cart
        restTemplate.postForLocation(cartServerUrl + "/{cartNumber}", new CartLine(3, watch), "1010");
        System.out.println("---- added the product to the shopping cart -----");

        // get the shopping cart
        ShoppingCart cart = restTemplate.getForObject(cartServerUrl + "/{cartNumber}", ShoppingCart.class, "1010");
        System.out.println(" ---- getting the shopping cart ----");
        System.out.println(cart);

    }
}
