package com.obredor.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obredor.library.models.entities.UserLocation;

public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
  
}
