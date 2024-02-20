package com.example.INMEM.persistence.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@Entity
@Table(name = "books")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookEntity {


    @Id
    private String isbn;

    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
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
    private BookEntity(String name){
        throw new IllegalStateException("Use Builder for initialization");
    }


    // Default constructor for JPA
    public BookEntity(){

    }


    // getters;

    public String getIsbn(){
        return isbn;
    }

    public String getTitle(){
        return title;
    }

    // Class Builder
    public static class builder {

        private final BookEntity bookEntity = new BookEntity();


        public builder setTitle(String title){
            bookEntity.title = title;
            return this;
        }


        public builder setIsbn(String isbn){
            bookEntity.isbn = isbn;
            return this;
        }

        public builder setAuthor(AuthorEntity authorEntity){
            bookEntity.authorEntity = authorEntity;
            return this;
        }

        public BookEntity build(){
            return bookEntity;
        }


    }

























}
