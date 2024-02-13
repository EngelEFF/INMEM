package com.example.INMEM.service;


import com.example.INMEM.persistence.Books;
import com.example.INMEM.persistence.BooksRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    private BooksRepo booksRepo;

    public BooksService(BooksRepo booksRepo){
        this.booksRepo = booksRepo;
    }


    public void createNewBook(Books book){

        booksRepo.save(book);
    }

    public  Optional<Books> findBookById(String id){

        return booksRepo.findById(id);
    }


}
