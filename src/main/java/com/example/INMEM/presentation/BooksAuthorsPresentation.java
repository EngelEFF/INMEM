package com.example.INMEM.presentation;


import com.example.INMEM.persistence.Authors;
import com.example.INMEM.persistence.Books;
import com.example.INMEM.service.AuthorsService;
import com.example.INMEM.service.BooksService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("webApp/BooksAuthors")
public class BooksAuthorsPresentation {

    private ObjectMapper objectMapper;
    private AuthorsService authorService;
    private BooksService bookService;

    @Autowired
    public BooksAuthorsPresentation(AuthorsService authorService, BooksService bookService, ObjectMapper objectMapper){

        this.authorService = authorService;
        this.bookService = bookService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public String findAllAuthors() throws JsonProcessingException {

        return objectMapper.writeValueAsString(authorService.findAllEntities());
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


    @GetMapping( path = "/ageLessThan/{age}")
    public List<Authors> ageLessThan(@PathVariable int age){
      return  authorService.ageLessThan(age);
    }


    @GetMapping( path = "/ageGreaterThan/{age}")
    public List<Authors> ageGreaterThan(@PathVariable int age){

        return authorService.ageGreaterThan(age);
    }


    @GetMapping( path = "/Greater/{age}")
    public List<Authors> greater(@PathVariable int age){
        return authorService.findAgeGreaterThan(age);
    }

    @PostMapping( path = "/create/books" )

    public Books createBook(@RequestBody final Books book){
        bookService.createNewBook(book);
        return book;

    }


    @PostMapping( path = "/create/authors" )

    public Authors createAuthor(@RequestBody final Authors author){
        authorService.InsertAuthor(author);
        return author;

    }


    @DeleteMapping( path = "/delete/author/{id}")

    public String deleteAuthor(@PathVariable Long id){

        authorService.deleteAuthor(id);

        return "Successfully deleted";
    }




}
