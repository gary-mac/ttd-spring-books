package com.example.tddspringbooks;

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

    @Test
    void getAllToDos(){
        Book book = new Book("Clean Code", "Robert Martin", "2234");
        bookRepository.save(book);
        BookService toDoService = new BookService(bookRepository);

        Book firstBook = toDoService.findAll().get(0);

        assertEquals(book.getTitle(), firstBook.getTitle());
        assertEquals(book.getAuthor(), firstBook.getAuthor());
        assertEquals(book.getIsbn(), firstBook.getIsbn());
    }
}
