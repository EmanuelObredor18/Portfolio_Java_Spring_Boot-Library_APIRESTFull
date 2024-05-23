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
public class UserId {
  
  @Column(nullable = false, length = 40)
  private String userId;

  @Column(nullable = false, length = 2)
  private String userDocumentTypeId;

}
