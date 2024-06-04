package com.obredor.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obredor.library.models.entities.Book;

public interface BookRepository extends JpaRepository<Book, String> {
  
}
