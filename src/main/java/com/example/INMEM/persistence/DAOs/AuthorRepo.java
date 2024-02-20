package com.example.INMEM.persistence.DAOs;

import com.example.INMEM.persistence.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepo extends JpaRepository<AuthorEntity, Long> {


}
