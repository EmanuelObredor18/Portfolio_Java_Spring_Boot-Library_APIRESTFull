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
@Table(name = "NUMBER_PREFIXES")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NumberPrefix implements BaseEntity<String> {

  @Id
  @Column(length = 6)
  private String prefixId;

  @Column(length = 30, nullable = false)
  private String prefixCountry;

  @Override
  public String getId() {
    return this.prefixId;
  }
}
