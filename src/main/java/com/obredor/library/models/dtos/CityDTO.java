package com.obredor.library.models.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CityDTO {
  
  private String cityId;

  private String cityName;

  private String countryIsoCode;

  private String administrativeDivisionCode;

  private AdministrativeDivisionDTO administrativeDivision;

}
