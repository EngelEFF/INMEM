package com.example.INMEM.presentation;

import com.example.INMEM.mappers.Mapper;
import com.example.INMEM.persistence.DTOs.BookDTO;
import com.example.INMEM.persistence.entities.BookEntity;
import com.example.INMEM.service.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequestMapping("books")
@RestController
public class BooksController {


    private BookService bookService;
    private Mapper<BookEntity, BookDTO> bookMapper;

    @Autowired
    public BooksController(BookService bookService, Mapper<BookEntity, BookDTO> bookMapper){
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }


    @PutMapping(path = "/book/{isbn}")
    public ResponseEntity<BookDTO> createBook(@PathVariable("isbn") String isbn,
                                              @RequestBody BookDTO bookDTO){

        BookEntity bookEntity = bookMapper.mapFrom(bookDTO);

        BookEntity savedBookEntity = bookService.save(isbn, bookEntity);

        BookDTO savedBookDto = bookMapper.mapTo(savedBookEntity);

        return new ResponseEntity<>(savedBookDto, HttpStatus.CREATED);


    }

    @PutMapping( path ="/update/{isbn}")
    public ResponseEntity<BookDTO> updateABook(@PathVariable("isbn") String isbn,
                                               @RequestBody BookDTO bookDTO){

        if(bookService.exists(isbn)){

            BookEntity update = bookMapper.mapFrom(bookDTO);
            BookEntity updated = bookService.save(isbn, update);
            BookDTO updatedDTO = bookMapper.mapTo(updated);

            return new ResponseEntity<>(updatedDTO, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping
    public List<BookDTO> listBooks(){

        List<BookEntity> books = bookService.findAllEntities();

        return books.
                stream().
                map(bookMapper::mapTo).
                collect(Collectors.toList());
    }

    
    @GetMapping(path  = "/{isbn}")
    public ResponseEntity<BookDTO> findABook(@PathVariable("isbn") String isbn){

        Optional<BookEntity> retrievedBook = bookService.findOne(isbn);
        
       return retrievedBook.map( bookEntity -> {
            
            BookDTO bookDTO = bookMapper.mapTo(bookEntity);
            return new ResponseEntity<>(bookDTO, HttpStatus.OK);
            
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping(path = "/delete" )
    public String deleteAll(){

       return bookService.clear();
    }
    
    

}
