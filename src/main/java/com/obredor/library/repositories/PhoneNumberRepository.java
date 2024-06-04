package com.obredor.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obredor.library.models.embeddables.PhoneNumberId;
import com.obredor.library.models.entities.PhoneNumber;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, PhoneNumberId> {
  
}
