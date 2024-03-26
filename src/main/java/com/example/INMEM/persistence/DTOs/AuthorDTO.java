package com.example.INMEM.persistence.DTOs;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class AuthorDTO {

    public Long authorID;
    public String name;
    public int age;

    public AuthorDTO(){}





    //setters



    public void setAuthorID(Long authorID){
        this.authorID = authorID;
    }

    public void setName(String name) {

        this.name = name;
    }


    public void setAge(int age){
        this.age = age;
    }


    // getters
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }


    public Long getAuthorID() {
        return authorID;
    }

    // builder
    public static class builder {
        private final AuthorDTO authorDto = new AuthorDTO();


        public builder setName(String name){
            authorDto.name = name;
            return this;
        }

        public builder setAge(int age){
            authorDto.age = age;
            return this;
        }

        public AuthorDTO build(){
            return authorDto;
        }

    }


}
