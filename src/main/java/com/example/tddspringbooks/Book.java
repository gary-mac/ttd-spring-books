package com.example.tddspringbooks;

public class Book {

    private Long id;
    private String title;
    private String author;
    private String isbn;

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
