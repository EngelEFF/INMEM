package com.example.INMEM.presentation;

import com.example.INMEM.mappers.Mapper;
import com.example.INMEM.mappers.impl.AuthorMapper;
import com.example.INMEM.persistence.DTOs.AuthorDTO;
import com.example.INMEM.persistence.entities.AuthorEntity;
import com.example.INMEM.service.AuthorsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("authors")
@RestController
public class AuthorsController{

    private AuthorsService authorsService;
    private AuthorDTO authorDTO;
    private Mapper<AuthorEntity, AuthorDTO> authorMapper;

    @Autowired
    public AuthorsController(AuthorsService authorsService, Mapper<AuthorEntity, AuthorDTO> authorMapper){

        this.authorsService = authorsService;
        this.authorMapper = authorMapper;
    }


    @PostMapping(path = "/create")
    public AuthorDTO createAuthor(@RequestBody AuthorDTO authorDTO){

        ModelMapper modelMapper = new ModelMapper();
        // This converts author dto to an author entity to be saved
        AuthorEntity authorEntity = authorMapper.mapFrom(authorDTO);
        // Then author entity is then saved and the returned instance is
        // stored in saved entity
        AuthorEntity savedEntity = authorsService.createAuthor(authorEntity);

        // The saved author entity is then converted back into an author dto
        return authorMapper.mapTo(savedEntity);


    } /*


    @PostMapping(path = "/create")
    public AuthorEntity createAuthor(@RequestBody AuthorEntity authorEntity){

        return authorsService.createAuthor(authorEntity);
    }

    @GetMapping(path = "/greet")
    public String greet(){

        return "Hello, how are you doing?";
    }
    */
}