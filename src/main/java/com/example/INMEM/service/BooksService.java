package com.example.INMEM.service;


import com.example.INMEM.persistence.entities.BookEntity;
import com.example.INMEM.persistence.DAOs.BookRepo;
import com.example.INMEM.service.impl.BookService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BooksService implements BookService {

    private BookRepo bookRepo;

    public BooksService(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }


    @Override
    public BookEntity createBook(String isbn, BookEntity bookEntity){
        bookEntity.setIsbn(isbn); // This will save the isbn that will be entered in the url
        return bookRepo.save(bookEntity);
    }



}
