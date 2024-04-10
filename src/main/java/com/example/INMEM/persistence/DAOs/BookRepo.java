package com.example.INMEM.persistence.DAOs;

import com.example.INMEM.persistence.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BookRepo extends JpaRepository<BookEntity, String>,
        PagingAndSortingRepository<BookEntity, String> {


}
