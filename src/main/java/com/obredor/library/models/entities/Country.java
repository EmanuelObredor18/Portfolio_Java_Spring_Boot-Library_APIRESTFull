package com.obredor.library.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "COUNTRIES")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Country {
  
  @Id
  @Column(length = 3)
  private String isoCode;

  @Column(length = 50, nullable = false)
  private String name;

}
