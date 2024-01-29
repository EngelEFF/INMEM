package com.example.INMEM;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import javax.sql.DataSource;

@SpringBootApplication
public class InmemApplication implements CommandLineRunner{


	public static void main(String[] args) {
		SpringApplication.run(InmemApplication.class, args);
	}

	public void run(String... args){

	}

}
