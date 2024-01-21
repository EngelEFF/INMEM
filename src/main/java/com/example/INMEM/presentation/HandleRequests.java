package com.example.INMEM.presentation;

import com.example.INMEM.persistence.Products;
import com.example.INMEM.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
/*
@RequestMapping
 This annotation categories all the methods inside this class under a
 single url which begins with webApp. This means that several
 RestController classes can be created with unique set of methods
 working to gether to perform differenct functionalities within the same
 application

 #Tip: A single application can run on several port independently. Instances
 of the single application can run on different port at the same time without
 affecting perfomance with other instances. The underlying database changes
 will reflects in all instances,
 */
@RequestMapping("/webApp")
public class HandleRequests {

    private ProductService service;

    @Autowired
    public HandleRequests(ProductService service){
        this.service = service;
    }

    /*
    GetMapping without an argument specifies the root directory webApp It can
    then be used to display the homepage of an application
     */
    @GetMapping
    public List<Products>  listAllProduct(){
        return service.findAllProducts();
    }
/*
    @GetMapping("/{id}")
    public ResponseEntity<Products> getEntitybyID(@PathVariable Long id){
        ;
    }


*/


    @GetMapping("/hello")
    public String get(){

        return "Hello world!";
    }

}
