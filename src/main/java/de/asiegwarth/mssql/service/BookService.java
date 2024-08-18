package de.asiegwarth.mssql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.asiegwarth.mssql.entity.Book;
import de.asiegwarth.mssql.entity.BookCommand;
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

        @Override
        public ResponseEntity enterNewBook(BookCommand book) {
            Book newBook = new Book();
            newBook.setAuthorFirstname(book.getFirstname());
            newBook.setAuthorLastname(book.getLastname());
            newBook.setTitle(book.getTitle());
            try {
                Book savedBook = bookRepo.save(newBook);
                return ResponseEntity.ok(savedBook);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.badRequest().body("error");
            }
        }
    }

    ResponseEntity getAllBooks();

    ResponseEntity enterNewBook(BookCommand book);
    
}
