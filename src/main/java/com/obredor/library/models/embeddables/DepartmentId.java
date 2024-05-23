package com.obredor.library.models.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Embeddable
public class DepartmentId {
  @Column(length = 2, nullable = false)
  private String code;

  @Column(length = 3, nullable = false)
  private String countryIsoCode;
}
