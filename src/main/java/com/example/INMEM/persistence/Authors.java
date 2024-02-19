package com.example.INMEM.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
@Table(name = "authors")
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="author_id_seq")
    private Long authorID;

    @JsonProperty("Author's name")
    String name;

    @JsonProperty("Author's age")
    int age;

    public Authors(){ }


    /*
    public Authors(String name, int age){

        this.name = name;
        this.age = age;
    }


    public void setName(String name) {

        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }


     */


    // getters
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    // builder
    public static class builder {
        private final Authors author  = new Authors();


        public builder setName(String name){
            author.name = name;
            return this;
        }

        public builder setAge(int age){
            author.age = age;
            return this;
        }

        public Authors build(){
            return author;
        }

    }
}

