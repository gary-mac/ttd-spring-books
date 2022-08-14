package com.example.tddspringbooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Long createNewBook(BookRequest bookRequest) {
        Book book = new Book();

        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setIsbn(bookRequest.getIsbn());

     //   book = bookRepository.saveBook(book);

        return book.getId();
    }

    public List<Book> findAll() {
        return new ArrayList<>();
    }
}
