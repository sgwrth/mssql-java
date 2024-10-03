package de.asiegwarth.mssql.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.asiegwarth.mssql.entity.Book;
import de.asiegwarth.mssql.entity.BookCommand;
import de.asiegwarth.mssql.repository.BookRepository;

public interface BookService {

    @Service
    class BookServiceImpl implements BookService {

        private final BookRepository bookRepo;

        public BookServiceImpl(BookRepository bookRepo) {
            this.bookRepo = bookRepo;
        }

        @Override
        public ResponseEntity<List<Book>> getAllBooks() {
            List<Book> books;
            try {
                books = bookRepo.findAll();
                return ResponseEntity.ok(books);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.badRequest().build();
            }
        }

        @Override
        public ResponseEntity<Book> getBookById(int id) {
            try {
                return ResponseEntity.ok(bookRepo.findById(id).orElseThrow());
            } catch (Exception e) {
                return ResponseEntity.badRequest().build();
            }
        }

        @Override
        public ResponseEntity<Book> enterNewBook(BookCommand book) {
            Book newBook = new Book();
            newBook.setAuthorFirstname(book.getFirstname());
            newBook.setAuthorLastname(book.getLastname());
            newBook.setTitle(book.getTitle());
            try {
                Book savedBook = bookRepo.save(newBook);
                return ResponseEntity.ok(savedBook);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.badRequest().build();
            }
        }
    }

    ResponseEntity<List<Book>> getAllBooks();

    ResponseEntity<Book> getBookById(int id);

    ResponseEntity<Book> enterNewBook(BookCommand book);
    
}
