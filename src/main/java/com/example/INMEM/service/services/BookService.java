package com.example.INMEM.service.services;

import com.example.INMEM.persistence.entities.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public BookEntity save(String isbn, BookEntity bookEntity);

    public List<BookEntity> findAllEntities();

    public Page<BookEntity> findAll(Pageable pageable);

    public void deleteBooks();

    public Optional<BookEntity> findOne(String isbn);

    public Boolean exists(String isbn);

    public BookEntity partialUpdate(String id, BookEntity entity);

    public void deleteBook(String isbn);


}
