package com.bookapplication.service;

import com.bookapplication.model.Book;

import java.util.List;

public interface BookInterface {
    Book addBook(Book book);

    Book updateBook(Book book);

    void deleteBook(String isbn);

    Book getBook(String isbn);

    List<Book> getAllBooks();
}
