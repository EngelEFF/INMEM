package com.example.INMEM.persistence.DTOs;


import com.example.INMEM.persistence.entities.AuthorEntity;
import com.example.INMEM.persistence.entities.BookEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
public class BookDTO {


    private String isbn;

    private String title;

    private AuthorEntity authorEntity;

    /*
    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }


    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public Authors getAuthors() {
        return authors;
    }
*/

    // private constructor to assert the use of builder class

    /*
    Though it is not necessary to give the private constructor a
    parameter but I need to use method overloading in order to maintain
    both constructors;

     */
    private BookDTO(String name) {
        throw new IllegalStateException("Use Builder for initialization");
    }


    // Default constructor for JPA
    public BookDTO() {

    }


    // getters;

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    // Class Builder
    public static class builder {

        private final BookDTO bookDto = new BookDTO();


        public builder setTitle(String title) {
            bookDto.title = title;
            return this;
        }


        public builder setIsbn(String isbn) {
            bookDto.isbn = isbn;
            return this;
        }

        public builder setAuthor(AuthorEntity authorEntity) {
            bookDto.authorEntity = authorEntity;
            return this;
        }

        public BookDTO build() {
            return bookDto;
        }


    }

}