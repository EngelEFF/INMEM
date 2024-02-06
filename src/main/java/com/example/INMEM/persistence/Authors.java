package com.example.INMEM.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "authors")
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id")
    private Long authorID;
    String name;
    int age;

    public Authors(){ }

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
}

