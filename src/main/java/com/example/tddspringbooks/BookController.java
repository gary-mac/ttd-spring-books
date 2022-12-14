package com.example.tddspringbooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/books")
    ResponseEntity<Book> create(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }
}
