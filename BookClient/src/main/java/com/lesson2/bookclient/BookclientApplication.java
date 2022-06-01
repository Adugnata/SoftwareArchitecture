package com.lesson2.bookclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BookclientApplication implements CommandLineRunner {
        @Autowired
        private RestOperations restTemplate;

        public static void main(String[] args) {
            SpringApplication.run(BookclientApplication.class, args);
        }

        @Override
        public void run(String... args) throws Exception {
            String serverUrl = "http://localhost:8080/book";

            // add Java
            restTemplate.postForLocation(serverUrl, new Book("1234","Java", "James",
                    123.45));
            // add C++
            restTemplate.postForLocation(serverUrl, new Book("5678","C++", "John",
                    45.67));
            // get Java
            Book book = restTemplate.getForObject(serverUrl+"/{isbn}", Book.class, "1234");
            System.out.println("----------- get Java-----------------------");
            System.out.println(book.getTitle()+" "+book.getAuthor());
            // get all
            Books books= restTemplate.getForObject(serverUrl, Books.class);
            System.out.println("----------- get all books-----------------------");
            System.out.println(books);

            // delete C++
            restTemplate.delete(serverUrl+"/{isbn}", "5678");

            // update Java
            book.setAuthor("Jame Gosling");
            restTemplate.put(serverUrl+"/{isbn}", book,book.getIsbn());

            // get all
            books= restTemplate.getForObject(serverUrl, Books.class);
            System.out.println("----------- get all books-----------------------");
            System.out.println(books);
        }


        @Bean
        RestOperations restTemplate() {
            return new RestTemplate();
        }
    }
