package com.obredor.library.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obredor.library.models.entities.UserContact;

public interface UserContactRepository extends JpaRepository<UserContact, Long> {
  
}
