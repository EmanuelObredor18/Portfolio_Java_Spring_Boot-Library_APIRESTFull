package com.obredor.library.models.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDTO {
  
  private String userId;

  private String userDocumentTypeId;

  private String firstName;

  private String secondName;

  private String lastName;

}
