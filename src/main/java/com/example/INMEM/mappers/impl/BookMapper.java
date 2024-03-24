package com.example.INMEM.mappers.impl;

import com.example.INMEM.mappers.Mapper;
import com.example.INMEM.persistence.DTOs.BookDTO;
import com.example.INMEM.persistence.entities.BookEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements Mapper<BookEntity, BookDTO> {

    private ModelMapper modelMapper;

    @Autowired
    public BookMapper(ModelMapper modelMapper){

        this.modelMapper = modelMapper;
    }

    public BookDTO mapTo(BookEntity bookEntity){
        return modelMapper.map(bookEntity, BookDTO.class);
    }

    public BookEntity mapFrom(BookDTO bookDTO){
        return modelMapper.map(bookDTO, BookEntity.class);
    }

}
