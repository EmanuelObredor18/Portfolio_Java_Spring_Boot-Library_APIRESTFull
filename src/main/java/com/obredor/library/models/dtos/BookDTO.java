package com.obredor.library.models.dtos;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookDTO {

  private String bookIsbn;

  private String title;

  private String description;

  private String imgSource;

  private Set<AuthorDTO> authors;

  private Set<LoanDTO> loans;
}
