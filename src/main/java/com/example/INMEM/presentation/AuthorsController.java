package com.example.INMEM.presentation;

import com.example.INMEM.mappers.Mapper;
import com.example.INMEM.persistence.DTOs.AuthorDTO;
import com.example.INMEM.persistence.entities.AuthorEntity;
import com.example.INMEM.service.impl.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO){


        // This converts author dto to an author entity to be saved
        AuthorEntity authorEntity = authorMapper.mapFrom(authorDTO);
        // Then author entity is then saved and the returned instance is
        // stored in saved entity
        AuthorEntity savedEntity = authorsService.save(authorEntity);

        // The saved author entity is then converted back into an author dto
        AuthorDTO authorDTO1 = authorMapper.mapTo(savedEntity);

        return new ResponseEntity<>(authorDTO, HttpStatus.CREATED);

    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<AuthorDTO> update(@PathVariable("id") Long id,
                                            @RequestBody AuthorDTO authorDTO){
        if(!authorsService.exists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            authorDTO.setAuthorID(id);

            AuthorEntity author = authorMapper.mapFrom(authorDTO);

            AuthorEntity update = authorsService.save(author);

            AuthorDTO updated = authorMapper.mapTo(update);

            return new ResponseEntity<>(updated, HttpStatus.OK);

        }

    }
    @PatchMapping(path = "/updateProp/{id}")
    public ResponseEntity<AuthorDTO> updatePartially(@PathVariable("id") Long id,
                                                     @RequestBody AuthorDTO authorDTO){

        if (authorsService.exists(id)){

            AuthorEntity author = authorMapper.mapFrom(authorDTO);
            AuthorEntity partiallyUpdated = authorsService.partialUpdate(id,author);
            AuthorDTO partiallyUpdatedDTO = authorMapper.mapTo(partiallyUpdated);
            return new ResponseEntity<>(partiallyUpdatedDTO, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }



    }

    @GetMapping
    public List<AuthorDTO> listAuthors(){

        List<AuthorEntity> authors = authorsService.findAllEntities();
        return authors.stream().
                map(authorMapper::mapTo).
                collect(Collectors.toList());
    }

    @GetMapping(path = "author/{id}")
    public ResponseEntity<AuthorDTO> findAuthor(@PathVariable("id") Long id){

        Optional<AuthorEntity> retrievedEntity = authorsService.findOne(id);



        return retrievedEntity.map( authorEntity -> {

            AuthorDTO authorDTO = authorMapper.mapTo(authorEntity);
            return new ResponseEntity<>(authorDTO, HttpStatus.OK);

        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



}