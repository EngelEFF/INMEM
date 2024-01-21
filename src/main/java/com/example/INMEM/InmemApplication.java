package com.example.INMEM;

import com.example.INMEM.persistence.Products;
import com.example.INMEM.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import javax.sql.DataSource;

@SpringBootApplication
public class InmemApplication implements CommandLineRunner{

	ProductService productService;

	public InmemApplication(ProductService productService){this.productService = productService;}
	public static void main(String[] args) {
		SpringApplication.run(InmemApplication.class, args);
	}

	public void run(String... args){

		Products products = new Products();
		products.setName("Tomato pastes");
		products.setQuantity(5);
		products.setUnitPrice(3.5);
		productService.InsertNewProduct(products);


		products.setName("Tomato pastes");
		products.setQuantity(5);
		products.setUnitPrice(3.5);
		productService.InsertNewProduct(products);

		System.out.println(productService.findAllProducts());


	}

}
