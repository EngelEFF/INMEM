package com.example.INMEM;


import com.example.INMEM.persistence.Authors;
import com.example.INMEM.persistence.Books;
import com.example.INMEM.service.AuthorsService;
import com.example.INMEM.service.BooksService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class InmemApplication implements CommandLineRunner{

	private BooksService bookService;
	private AuthorsService authorService;
	private ObjectMapper objectMapper;

	public InmemApplication(AuthorsService authorsService,
							BooksService bookService,
							ObjectMapper objectMapper){

		this.authorService = authorsService;
		this.bookService = bookService;
		this.objectMapper = objectMapper;

	}

	public static void main(String[] args) {
		SpringApplication.run(InmemApplication.class, args);
	}

	public void run(String... args) throws JsonProcessingException {


		Authors authorA = new Authors.builder().
				setName("Kwin").
				setAge(25).
				build();




			Books booksA = new Books.builder().
					setTitle("Cinderella").
					setIsbn("a").
					setAuthor(authorA).
					build();

		bookService.createNewBook(booksA);



		Authors authorB = new Authors.builder().
				setName("Birian").
				setAge(25).
				build();



		Books booksB = new Books.builder().
				setTitle("Ananse in the Land of idiots").
				setIsbn("ab").
				setAuthor(authorB).
				build();

		bookService.createNewBook(booksB);




		Authors authorC = new Authors.builder().
				setName("William ShakesPeare").
				setAge(27).
				build();



		Books booksC = new Books.builder().
				setTitle("The Merchant of Venice").
				setIsbn("abc").
				setAuthor(authorC).
				build();

		bookService.createNewBook(booksC);





		objectMapper.writeValueAsString(booksA);
	}

}
