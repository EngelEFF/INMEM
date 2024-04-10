package com.example.INMEM.service.impl;


import com.example.INMEM.persistence.DAOs.BookRepo;
import com.example.INMEM.persistence.entities.BookEntity;
import com.example.INMEM.service.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService implements BookService {

    private BookRepo bookRepo;

    @Autowired
    public BooksService(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }


    @Override
    public BookEntity save(String isbn, BookEntity bookEntity){
        bookEntity.setIsbn(isbn); // This will save the isbn that will be entered in the url
        return bookRepo.save(bookEntity);
    }


    @Override
    public List<BookEntity> findAllEntities(){
        return bookRepo.findAll();
    }

    @Override
    public Page<BookEntity> findAll(Pageable pageable){
        return bookRepo.findAll(pageable);
    }


    @Override
    public Optional<BookEntity> findOne(String isbn){

        return bookRepo.findById(isbn);
    }

    @Override
    public Boolean exists(String isbn){

        return bookRepo.existsById(isbn);
    }
    
    @Override
    public BookEntity partialUpdate(String isbn, BookEntity bookEntity){

        bookEntity.setIsbn(isbn);

        return bookRepo.findById(isbn).map( retrievedBookEntity -> {

            Optional.ofNullable(bookEntity.getTitle()).ifPresent(retrievedBookEntity::setTitle);

             return bookRepo.save(retrievedBookEntity);

        }).orElseThrow(() -> new RuntimeException("Book entity doesn't exists"));


    }

    @Override
    public void deleteBook(String isbn){
        bookRepo.deleteById(isbn);
    }

    @Override
    public void deleteBooks(){
        bookRepo.deleteAll();
    }


}
