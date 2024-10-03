package de.asiegwarth.mssql.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.asiegwarth.mssql.entity.Book;
import de.asiegwarth.mssql.entity.BookCommand;
import de.asiegwarth.mssql.service.BookService;

@RestController
@CrossOrigin
public class BookController {
    
    private final BookService bookServ;

    public BookController(BookService bookServ) {
        this.bookServ = bookServ;
    }

    @GetMapping("/")
    private ResponseEntity<List<Book>> getAllBooks() {
        return bookServ.getAllBooks();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
        return bookServ.getBookById(id);
    }

    @PostMapping("/")
    private ResponseEntity<Book> enterNewBook(@RequestBody BookCommand book) {
        return bookServ.enterNewBook(book);
    }
}
