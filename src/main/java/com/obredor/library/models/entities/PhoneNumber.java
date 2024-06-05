package com.obredor.library.models.entities;

import com.obredor.library.models.embeddables.PhoneNumberId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "PHONE_NUMBERS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PhoneNumber implements BaseEntity<PhoneNumberId> {
  
  @EmbeddedId
  private PhoneNumberId phoneNumberId;

  @OneToOne
  @JoinColumn(name = "prefixId", referencedColumnName = "prefixId", insertable = false, updatable = false)
  private NumberPrefix numberPrefix;

  @Override
  public PhoneNumberId getId() {
    return this.phoneNumberId;
  }
}
