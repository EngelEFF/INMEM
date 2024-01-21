package com.example.INMEM.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*

This is an interface which extends the jpa interface to inherit existing methods
which will allow one to perform the crud operations with only methods.
Custom implementations can be provided, However the basic crud operations
can be performed with any customer methods.
 */
@Repository
public interface ProductRepo extends JpaRepository<Products,Long>{}


