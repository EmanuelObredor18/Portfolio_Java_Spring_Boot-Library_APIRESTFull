package com.obredor.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obredor.library.models.entities.UserContact;

public interface UserContactRepository extends JpaRepository<UserContact, Long> {
  
}
