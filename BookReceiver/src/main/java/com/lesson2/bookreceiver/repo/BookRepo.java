package com.lesson2.bookreceiver.repo;

import com.lesson2.bookreceiver.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, String> {


}
