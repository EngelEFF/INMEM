package com.example.INMEM.service.impl;

import com.example.INMEM.persistence.entities.BookEntity;

public interface BookService {

    public BookEntity createBook(String isbn, BookEntity bookEntity);
}
