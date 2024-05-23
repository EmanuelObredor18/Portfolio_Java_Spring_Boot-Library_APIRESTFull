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
public class PhoneNumberId {
  
  @Column(nullable = false, length = 35)
  private String number;

  @Column(nullable = false, length = 6)
  private String prefixId;
}
