package com.example.tddspringbooks;

import javax.persistence.Entity;

@Entity
public class Book {

    private Long id;
    private String title;
    private String author;
    private String isbn;

    public Book() {}
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }
}
