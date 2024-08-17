package de.asiegwarth.mssql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.asiegwarth.mssql.entity.Book;
import de.asiegwarth.mssql.repository.BookRepository;

public interface BookService {

    @Service
    class BookServiceImpl implements BookService {

        @Autowired
        BookRepository bookRepo;

        @Override
        public ResponseEntity getAllBooks() {
            List<Book> books;
            try {
                books = bookRepo.findAll();
                return ResponseEntity.ok(books);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.badRequest().body("server error");
            }
        }
    }

    ResponseEntity getAllBooks();
    
}
