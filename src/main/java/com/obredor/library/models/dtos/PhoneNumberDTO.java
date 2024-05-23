package com.obredor.library.models.dtos;

import com.obredor.library.models.entities.NumberPrefix;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PhoneNumberDTO {

  private String number;

  private NumberPrefix numberPrefix;
}
