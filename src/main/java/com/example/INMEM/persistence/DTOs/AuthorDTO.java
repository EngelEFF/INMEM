package com.example.INMEM.persistence.DTOs;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;


@Component
public class AuthorDTO {


    public String name;

    public int age;

    public AuthorDTO(){ }



    private AuthorDTO(String name, int age){

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

