package com.example.INMEM.persistence.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "authors")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="author_id_seq")
    private Long authorID;
    String name;
    int age;

    public AuthorEntity(){ }


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

    public Long getAuthorID() {
        return authorID;
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
        private final AuthorEntity authorEntity = new AuthorEntity();


        public builder setName(String name){
            authorEntity.name = name;
            return this;
        }

        public builder setAge(int age){
            authorEntity.age = age;
            return this;
        }

        public AuthorEntity build(){
            return authorEntity;
        }

    }
}

