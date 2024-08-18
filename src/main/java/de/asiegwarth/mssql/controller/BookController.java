package de.asiegwarth.mssql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.asiegwarth.mssql.entity.BookCommand;
import de.asiegwarth.mssql.service.BookService;

@RestController
public class BookController {
    
    @Autowired
    BookService bookServ;

    @GetMapping("/")
    @CrossOrigin
    private ResponseEntity getAllBooks() {
        return bookServ.getAllBooks();
    }

    @PostMapping("/")
    @CrossOrigin
    private ResponseEntity enterNewBook(@RequestBody BookCommand book) {
        return bookServ.enterNewBook(book);
    }
}
