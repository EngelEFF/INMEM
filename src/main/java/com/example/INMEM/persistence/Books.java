package com.example.INMEM.persistence;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@Entity
@Table(name = "books")
public class Books {


    @Id
    private String isbn;

    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Authors authors;

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
    private Books(String name){
        throw new IllegalStateException("Use Builder for initialization");
    }


    // Default constructor for JPA
    public Books(){

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

        private final Books book = new Books();


        public builder setTitle(String title){
            book.title = title;
            return this;
        }


        public builder setIsbn(String isbn){
            book.isbn = isbn;
            return this;
        }

        public builder setAuthor(Authors author){
            book.authors = author;
            return this;
        }

        public Books build(){

            return book;
        }


    }

























}
