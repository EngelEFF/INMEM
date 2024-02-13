package com.example.INMEM.presentation;


import com.example.INMEM.persistence.Authors;
import com.example.INMEM.persistence.Books;
import com.example.INMEM.service.AuthorsService;
import com.example.INMEM.service.BooksService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("webApp/BooksAuthors")
public class BooksAuthorsPresentation {

    private AuthorsService authorService;
    private BooksService bookService;

    @Autowired
    public BooksAuthorsPresentation(AuthorsService authorService, BooksService bookService){

        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping
    public List<Authors> findAllAuthors(){

        return authorService.findAllEntities();
    }
    @GetMapping("/{id}")

    public ResponseEntity<Authors> findAuthorById(@PathVariable Long id){

        return authorService.findAuthorById(id).
                map(ResponseEntity::ok).
                orElseGet(() ->  ResponseEntity.notFound().build());
    }



    public void createNewBook(Books book){


        bookService.createNewBook(book);

    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Books> findBookById(@PathVariable String id){

      return  bookService.findBookById(id).
              map(ResponseEntity::ok).
              orElseGet(()-> ResponseEntity.
                      notFound().build());
    }


    @GetMapping("/ageLessThan/{age}")
    public List<Authors> ageLessThan(@PathVariable int age){
      return  authorService.ageLessThan(age);
    }


    @GetMapping("/ageGreaterThan/{age}")
    public List<Authors> ageGreaterThan(@PathVariable int age){
        return authorService.ageGreaterThan(age);
    }


    @GetMapping("/Greater/{age}")
    public List<Authors> greater(@PathVariable int age){
        return authorService.findAgeGreaterThan(age);
    }
}
