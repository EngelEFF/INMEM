package com.example.INMEM.presentation;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("webApp/BooksAuthors")
public class BooksAuthorsPresentation {

    @GetMapping
    public String greet(){

        return "Welcome ones again Engelbert";
    }
}
