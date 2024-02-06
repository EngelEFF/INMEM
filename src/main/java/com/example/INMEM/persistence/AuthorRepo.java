package com.example.INMEM.persistence;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Authors, Long> {
}
