package com.example.INMEM;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class InmemApplication implements CommandLineRunner{

	/*
	private JdbcTemplate jdbcTemplate;

	public InmemApplication(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(InmemApplication.class, args);
	}

	public void run(String... args){

		//jdbcTemplate("SELECT * FROM employees;");

	}

}
