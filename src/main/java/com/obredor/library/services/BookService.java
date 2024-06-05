package com.obredor.library.services;

import org.springframework.stereotype.Service;

import com.obredor.library.models.dtos.BookDTO;
import com.obredor.library.models.entities.Book;
import com.obredor.library.services.base.BaseService;

@Service
public class BookService extends BaseService<Book, BookDTO, String> {
  
}
