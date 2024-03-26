package com.example.INMEM.service.services;

import com.example.INMEM.persistence.entities.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    public AuthorEntity save(AuthorEntity authorEntity);

    public Optional<AuthorEntity> findOne(Long id);

    public List<AuthorEntity> findAllEntities();

    public Boolean exists(Long id);

    public AuthorEntity partialUpdate(Long id, AuthorEntity authorEntity);
}
