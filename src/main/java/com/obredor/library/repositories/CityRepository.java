package com.obredor.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obredor.library.models.entities.City;

public interface CityRepository extends JpaRepository<City, String> {
  
}
