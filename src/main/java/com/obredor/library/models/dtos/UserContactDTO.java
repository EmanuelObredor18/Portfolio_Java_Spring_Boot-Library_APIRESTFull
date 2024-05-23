package com.obredor.library.models.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserContactDTO {

  private Long userContactId;

  private String email;

  private PhoneNumberDTO phoneNumber;

}
