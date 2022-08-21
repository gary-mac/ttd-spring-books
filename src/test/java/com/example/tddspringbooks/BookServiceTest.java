package com.example.tddspringbooks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookRepository bookRepository;

    @AfterEach
    public void tearDown() {
        bookRepository.deleteAll();
    }

    @Test
    void getAllBooks(){
        Book book = new Book("Clean Code", "Robert Martin", "2234");
        bookRepository.save(book);
        BookService bookService = new BookService(bookRepository);

        Book firstBook = bookService.findAll().get(0);

        assertEquals(book.getId(), firstBook.getId());
        assertEquals(book.getTitle(), firstBook.getTitle());
        assertEquals(book.getAuthor(), firstBook.getAuthor());
        assertEquals(book.getIsbn(), firstBook.getIsbn());
    }

    @Test
    void saveABook() {
        BookService bookService = new BookService(bookRepository);
        Book bookSample = new Book("Good Food", "Mick Martins", "3234");

        bookService.save(bookSample);

        assertEquals(1.0, bookRepository.count());
    }
}
