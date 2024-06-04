package com.obredor.library.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obredor.library.models.entities.UserDocumentType;

public interface UserDocumentTypeRepository extends JpaRepository<UserDocumentType, String> {
  
}
