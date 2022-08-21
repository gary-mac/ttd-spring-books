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
    void getAllToDos(){
        Book book = new Book("Clean Code", "Robert Martin", "2234");
        bookRepository.save(book);
        BookService toDoService = new BookService(bookRepository);

        Book firstBook = toDoService.findAll().get(0);

        assertEquals(book.getId(), firstBook.getId());
        assertEquals(book.getTitle(), firstBook.getTitle());
        assertEquals(book.getAuthor(), firstBook.getAuthor());
        assertEquals(book.getIsbn(), firstBook.getIsbn());
    }

    @Test
    void saveAToDo() {
        BookService bookService = new BookService(bookRepository);
        Book todoSample = new Book("Good Food", "Mick Martins", "3234");

        bookService.save(todoSample);

        assertEquals(1.0, bookRepository.count());
    }
}
