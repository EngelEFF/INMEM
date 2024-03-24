package com.example.INMEM.presentation;

import com.example.INMEM.mappers.Mapper;
import com.example.INMEM.persistence.DTOs.BookDTO;
import com.example.INMEM.persistence.entities.BookEntity;
import com.example.INMEM.service.impl.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("books")
@RestController
public class BooksController {

    private BookService bookService;
    private Mapper<BookEntity, BookDTO> bookMapper;

    public BooksController(BookService bookService){
        this.bookService = bookService;
    }

    @PutMapping(path = "/book/{isbn}")
    public ResponseEntity<BookDTO> createBook(@PathVariable("isbn") String isbn,
                                              @RequestBody BookDTO bookDTO){
        BookEntity bookEntity = bookMapper.mapFrom(bookDTO);

        BookEntity savedBookEntity = bookService.createBook(isbn, bookEntity);

        BookDTO savedBookDto = bookMapper.mapTo(savedBookEntity);

        return new ResponseEntity<>(savedBookDto, HttpStatus.CREATED);


    }
}
