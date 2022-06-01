package com.lesson2.bookreceiver.service;

import com.lesson2.bookreceiver.integration.JmsSender;
import com.lesson2.bookreceiver.model.Book;
import com.lesson2.bookreceiver.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookInterface {

    private final BookRepo bookRepo;
    private final JmsSender jmsSender;

    @Autowired
    public BookService(BookRepo bookRepo, JmsSender jmsSender) {
        this.bookRepo = bookRepo;
        this.jmsSender = jmsSender;
    }


    @Override
    public Book addBook(Book book) {
        bookRepo.save(book);
        jmsSender.sendMessage(book);
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        bookRepo.save(book);
        jmsSender.sendMessage(book);
        return book;
    }

    @Override
    public void deleteBook(String isbn) {
        Book book = bookRepo.findById(isbn).orElse(null);
        bookRepo.deleteById(isbn);
        jmsSender.sendMessage(book);
    }

    @Override
    public Book getBook(String isbn) {
        return bookRepo.findById(isbn).orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
}
