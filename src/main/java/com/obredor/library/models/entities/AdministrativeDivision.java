package com.obredor.library.models.entities;

import com.obredor.library.models.embeddables.AdministrativeDivisionId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "ADMINISTRATIVE_DIVISIONS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AdministrativeDivision {
  
  @EmbeddedId
  private AdministrativeDivisionId administrativeDivisionId;

  @Column(length = 50, nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "countryIsoCode", referencedColumnName = "isoCode", updatable = false, insertable = false)
  private Country country;
}
