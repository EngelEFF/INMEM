package com.example.INMEM.service.impl;


import com.example.INMEM.persistence.DAOs.AuthorRepo;
import com.example.INMEM.persistence.entities.AuthorEntity;
import com.example.INMEM.service.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorsService implements AuthorService {


    private AuthorRepo authorRepo;



    @Autowired
    public AuthorsService(AuthorRepo authorRepo){

        this.authorRepo = authorRepo;
    }


    public AuthorEntity save(AuthorEntity authorEntity){

        return authorRepo.save(authorEntity);
    }

    public List<AuthorEntity> findAllEntities(){

        return authorRepo.findAll();

    }

    public Optional<AuthorEntity> findOne(Long id){

        return authorRepo.findById(id);
    }

    public Boolean exists(Long id){

        return authorRepo.existsById(id);

    }

    public AuthorEntity partialUpdate(Long id, AuthorEntity authorEntity){

        authorEntity.setAuthorID(id);

        return authorRepo.findById(id).map( retrievedEntity -> {


            Optional.ofNullable(authorEntity.getName()).ifPresent(retrievedEntity::setName);

            // Due to the fact that the getAge will always return 0 that's why the implementation below
            Optional.of(authorEntity.getAge()).ifPresent(age -> {if(age != 0) retrievedEntity.setAge(age);});

            return authorRepo.save(retrievedEntity);

        }).orElseThrow(() -> new RuntimeException("Author doesn't exists"));

    }


}





