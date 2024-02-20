package com.example.INMEM.mappers.impl;


import com.example.INMEM.mappers.Mapper;
import com.example.INMEM.persistence.DTOs.AuthorDTO;
import com.example.INMEM.persistence.entities.AuthorEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorMapper implements Mapper<AuthorEntity, AuthorDTO> {

    private ModelMapper modelMapper;


    // calling the modelMapper from model mapper config  package
    @Autowired
    public AuthorMapper( ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDTO mapTo(AuthorEntity authorEntity){
        return modelMapper.map(authorEntity, AuthorDTO.class);
    }

    @Override
    public AuthorEntity mapFrom(AuthorDTO authorDto){
        return modelMapper.map(authorDto, AuthorEntity.class);
    }

}
