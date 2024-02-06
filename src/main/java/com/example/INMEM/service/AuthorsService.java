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


    public Optional<Authors> findbyId(Long id){

        return authorRepo.findById(id);
    }

    public List<Authors> findAllEntities(){

        List<Authors> authors = authorRepo.findAll();

    }

    public void deleteAuthor(Long id){
        authorRepo.deleteById(id);
    }

    public String updateAuthorName(Authors updatedAuthorEntity, Long id){

        Optional<Authors> potentialExistingEntity = findbyId(id);

        if(potentialExistingEntity.isPresent()){

            Authors actualExistingEntity = potentialExistingEntity.get();

            actualExistingEntity.setName(updatedAuthorEntity.getName());

            return "Name updated successfully";
        }
        else{

            throw new EntityNotFoundException("Entity not found");
        }


    }




}
