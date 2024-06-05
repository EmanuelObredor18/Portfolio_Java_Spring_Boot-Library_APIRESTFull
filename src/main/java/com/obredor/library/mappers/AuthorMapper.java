package com.obredor.library.mappers;

import org.springframework.stereotype.Component;

import com.obredor.library.mappers.base.GenericMapper;
import com.obredor.library.models.dtos.AuthorDTO;
import com.obredor.library.models.entities.Author;

@Component
public class AuthorMapper extends GenericMapper<Author, AuthorDTO> {
  
}
