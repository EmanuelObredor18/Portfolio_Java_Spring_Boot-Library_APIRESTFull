package com.obredor.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obredor.library.models.entities.NumberPrefix;

public interface NumberPrefixRepository extends JpaRepository<NumberPrefix, String >{
  
}
