package com.example.INMEM.presentation;


import com.example.INMEM.persistence.Authors;
import com.example.INMEM.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("webApp/BooksAuthors")
public class BooksAuthorsPresentation {

    private AuthorsService authorService;

    @Autowired
    public BooksAuthorsPresentation(AuthorsService authorService){
        this.authorService = authorService;
    }

    @GetMapping
    public String greet(){

        return "Welcome ones again Engelbert";
    }

    @GetMapping("/{id}")

    public ResponseEntity<Authors> findbyId(@PathVariable Long id){

        return authorService.findbyId(id).
                map(ResponseEntity::ok).
                orElseGet(() -> ResponseEntity.notFound().build());
    }
}
