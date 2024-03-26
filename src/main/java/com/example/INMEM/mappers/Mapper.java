package com.example.INMEM.mappers;

public interface Mapper<E, D> {

    D mapTo(E e);

    E mapFrom(D d);
}
