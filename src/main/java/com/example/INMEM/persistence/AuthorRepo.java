package com.example.INMEM.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepo extends JpaRepository<Authors, Long> {

    public List<Authors> ageLessThan(int age);
    public List<Authors> ageGreaterThan(int age);

    @Query("SELECT  a FROM Authors a WHERE a.age > ?1")
    public List<Authors> findAuthorWithAgeGreaterThan(int age);
}
