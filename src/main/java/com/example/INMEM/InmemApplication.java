package com.example.INMEM;


import com.example.INMEM.persistence.entities.AuthorEntity;
import com.example.INMEM.persistence.entities.BookEntity;
import com.example.INMEM.service.AuthorsService;
import com.example.INMEM.service.BooksService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class InmemApplication {


	public static void main(String[] args) {
		SpringApplication.run(InmemApplication.class, args);
	}


}
