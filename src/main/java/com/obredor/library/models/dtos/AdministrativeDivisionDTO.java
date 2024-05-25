package com.obredor.library.models.dtos;

import com.obredor.library.models.embeddables.AdministrativeDivisionId;
import com.obredor.library.models.entities.Country;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AdministrativeDivisionDTO {

  private AdministrativeDivisionId administrativeDivisionId;

  private String name;

  private Country country;
}
