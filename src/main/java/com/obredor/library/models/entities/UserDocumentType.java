package com.obredor.library.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "USER_DOCUMENT_TYPES")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDocumentType {

  @Id
  @Column(length = 2)
  private String userDocumentTypeId;

  @Column(nullable = false, length = 40)
  private String documentName;

}
