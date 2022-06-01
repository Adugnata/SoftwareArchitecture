package com.bookapplication.service;

import com.bookapplication.model.Book;
import com.bookapplication.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookInterface {

    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    @Override
    public Book addBook(Book book) {
        bookRepo.save(book);
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        bookRepo.save(book);
        return book;
    }

    @Override
    public void deleteBook(String isbn) {
        bookRepo.deleteById(isbn);
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
