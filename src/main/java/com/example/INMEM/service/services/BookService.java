package com.example.INMEM.service.services;

import com.example.INMEM.persistence.entities.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public BookEntity save(String isbn, BookEntity bookEntity);

    public List<BookEntity> findAllEntities();

    public String clear();

    public Optional<BookEntity> findOne(String isbn);

    public Boolean exists(String isbn);


}
