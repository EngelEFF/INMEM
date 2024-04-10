package com.example.INMEM.persistence.DTOs;



import org.springframework.stereotype.Component;

@Component
public class BookDTO {


    private String isbn;

    private String title;

    private AuthorDTO author;


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

    public void setAuthorDTO(AuthorDTO author){
        this.author = author;
    }

    public AuthorDTO getAuthorDTO() {
        return author;
    }

    // No args constructor
    // Default constructor for JPA
    public BookDTO() { }


    /*
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

        public builder setAuthor(AuthorDTO authorDTO) {
            bookDto.author = authorDTO;
            return this;
        }

        public BookDTO build() {
            return bookDto;
        }


    }


     */
}