package com.obredor.library.models.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserLocationDTO {
  
  private String country;

  private String city;

  private String address;

}
