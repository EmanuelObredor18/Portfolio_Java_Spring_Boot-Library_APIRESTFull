package com.obredor.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.obredor.library.models.entities.City;
import com.obredor.library.repositories.CityRepository;

@SpringBootTest
public class CityTest {
  
  @Autowired
  private CityRepository repository;

  @Test
  public void postCity() {
    City city = City.builder()
      .countryIsoCode("USA")
      .cityName("Una ciudad")
      .build();
      repository.save(city);
  }
}
