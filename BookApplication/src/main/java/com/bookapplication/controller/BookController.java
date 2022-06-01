package com.bookapplication.controller;

import com.bookapplication.model.Book;
import com.bookapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping("/addbook")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PostMapping("/updateBook")
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBook/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn) {
        bookService.deleteBook(isbn);
        return new ResponseEntity<Book>(HttpStatus.OK);
    }

    @GetMapping("book/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn) {
        Book book = bookService.getBook(isbn);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}
