package com.obredor.library.models.dtos;

import java.util.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AuthorDTO {
  
  private Long authorId;

  private String name;

  private String description;

  private Date birthDate;

  private Set<BookDTO> books;
}
