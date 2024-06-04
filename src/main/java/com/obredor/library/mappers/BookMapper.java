package com.obredor.library.mappers;

import org.springframework.stereotype.Component;

import com.obredor.library.mappers.base.GenericMapper;
import com.obredor.library.models.dtos.BookDTO;
import com.obredor.library.models.entities.Book;

@Component
public class BookMapper extends GenericMapper<Book, BookDTO>{

}
