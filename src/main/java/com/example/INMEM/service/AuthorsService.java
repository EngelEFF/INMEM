package com.example.INMEM.service;


import com.example.INMEM.persistence.DAOs.AuthorRepo;
import com.example.INMEM.persistence.entities.AuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorsService {


    private AuthorRepo authorRepo;



    @Autowired
    public AuthorsService(AuthorRepo authorRepo){

        this.authorRepo = authorRepo;
    }


    public void deleteAuthor(Long id){

        authorRepo.deleteById(id);
    }

    public AuthorEntity createAuthor(AuthorEntity authorEntity){

        return authorRepo.save(authorEntity);
    }


    public Optional<AuthorEntity> findAuthorById(Long id){

        return authorRepo.findById(id);
    }

    public List<AuthorEntity> findAllEntities(){

        return authorRepo.findAll();

    }
/*
    public void deleteAuthor(Long id){
        authorRepo.deleteById(id);
    }

    public String updateAuthorName(Authors updatedAuthorEntity, Long id){

        Optional<Authors> potentialExistingEntity = findAuthorById(id);

        if(potentialExistingEntity.isPresent()){

            Authors actualExistingEntity = potentialExistingEntity.get();

            actualExistingEntity.setName(updatedAuthorEntity.getName());

            return "Name updated successfully";
        }


        else{

            throw new EntityNotFoundException("Entity not found");
        }

 */
}





