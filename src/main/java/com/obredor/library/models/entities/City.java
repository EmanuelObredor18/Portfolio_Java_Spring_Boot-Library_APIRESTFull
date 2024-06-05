package com.obredor.library.models.entities;

import com.obredor.library.utils.CityCodeGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "CITIES")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class City implements BaseEntity<String> {
  
  @Id
  @Column(length = 6)
  private String cityId;

  @Column(length = 30, nullable = false)
  private String cityName;

  @Column(nullable = false, length = 3)
  private String countryIsoCode;

  @Column(length = 2, nullable = false)
  private String administrativeDivisionCode;

  @ManyToOne
  @JoinColumns({
      @JoinColumn(name = "countryIsoCode", referencedColumnName = "countryIsoCode", insertable = false, updatable = false),
      @JoinColumn(name = "administrativeDivisionCode", referencedColumnName = "code", insertable = false, updatable = false)
  })
  private AdministrativeDivision administrativeDivision;

  @PrePersist
  public void generateCityCode() {
    this.cityId = CityCodeGenerator.generateCityCode(this.cityName, administrativeDivisionCode);
  }

  @Override
  public String getId() {
    return this.cityId;
  }
}
