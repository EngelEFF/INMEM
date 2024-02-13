package com.example.INMEM.service;


import com.example.INMEM.persistence.AuthorRepo;
import com.example.INMEM.persistence.Authors;
import jakarta.persistence.EntityNotFoundException;
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


    public Authors InsertAuthor(Authors author){

        return authorRepo.save(author);
    }


    public Optional<Authors> findAuthorById(Long id){

        return authorRepo.findById(id);
    }

    public List<Authors> findAllEntities(){

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


    public List<Authors> ageLessThan(int age){
        return authorRepo.ageLessThan(age);
    }

    public List<Authors> ageGreaterThan(int age){

        return authorRepo.ageGreaterThan(age);
    }

    public List<Authors> findAgeGreaterThan(int age){
      return  authorRepo.findAuthorWithAgeGreaterThan(age);
    }
}





