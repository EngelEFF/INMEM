package com.example.INMEM.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BooksRepo extends JpaRepository<Books, String> {


}
