package com.obredor.library.repositories.user_location;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obredor.library.models.entities.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
  
}
