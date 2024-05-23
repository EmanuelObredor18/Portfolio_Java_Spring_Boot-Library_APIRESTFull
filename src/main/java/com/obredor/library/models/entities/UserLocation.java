package com.obredor.library.models.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "USER_LOCATIONS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserLocation {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userLocationId;

  @Column(nullable = false, length = 30)
  private String address;

  @Column(nullable = false, length = 3)
  private String countryIsoCode;

  @Column(length = 2, nullable = false)
  private String administrativeDivisionCode;

  @Column(length = 2, nullable = false)
  private String cityCode;

  @ManyToOne
  @JoinColumn(name = "countryIsoCode", referencedColumnName = "isoCode", insertable = false, updatable = false)
  private Country country;

  @ManyToOne
  @JoinColumns({
      @JoinColumn(name = "countryIsoCode", referencedColumnName = "countryIsoCode", insertable = false, updatable = false),
      @JoinColumn(name = "administrativeDivisionCode", referencedColumnName = "code", insertable = false, updatable = false)
  })
  private AdministrativeDivision administrativeDivision;

  @OneToMany(mappedBy = "userLocation", fetch = FetchType.LAZY)
  private List<User> users; 

  @ManyToOne
  @JoinColumn(name = "cityCode", referencedColumnName = "cityId", insertable = false, updatable = false)
  private City city;
}
