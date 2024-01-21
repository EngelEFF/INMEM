package com.example.INMEM.service;


import com.example.INMEM.persistence.ProductRepo;
import com.example.INMEM.persistence.Products;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepo proRepo;

    @Autowired
    ProductService(ProductRepo proRepo){
        this.proRepo = proRepo;
    }

    // inserts into products table
    @Transactional
    public Products InsertNewProduct(Products products){

        return proRepo.save(products);
    }

    // find all the products available
    @Transactional
    public List<Products> findAllProducts(){

        return proRepo.findAll();
    }

    // find a product by id
    public Optional<Products> findByID(Long id){ // optional is used in case the product doesn't exist

        return proRepo.findById(id);
    }

    // deletes a product by id
    @Transactional
    public void deleteProduct(Long id){
        proRepo.deleteById(id);
    }
    // deletes all the products
    public void deleteAllProducts(){
        proRepo.deleteAll();
    }

    // updating a product
    // This method update only single. This will cause duplication so find a solution for it.

    @Transactional
    public Products updateProduct(Long id, Products updatedProduct){

        Optional<Products>  existingProductOptional = proRepo.findById(id);

        if(existingProductOptional.isPresent()){

            Products existingProduct = existingProductOptional.get();

            existingProduct.setName(updatedProduct.getName());

            return proRepo.save(existingProduct);

        }
        else{
            throw new EntityNotFoundException("Entity with id "+id+" was not found");

        }

    }




}
