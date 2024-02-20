package com.example.INMEM.service;


import com.example.INMEM.persistence.entities.BookEntity;
import com.example.INMEM.persistence.DAOs.BookRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BooksService {

    private BookRepo bookRepo;

    public BooksService(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }


    public void createNewBook(BookEntity bookEntity){

        bookRepo.save(bookEntity);
    }

    public  Optional<BookEntity> findBookById(String id){

        return bookRepo.findById(id);
    }


}
