package com.obredor.library.models.entities;

import org.hibernate.validator.constraints.Length;

import com.obredor.library.models.embeddables.UserId;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {

  @EmbeddedId
  private UserId userId;

  @Column(nullable = false, length = 20)
  @NotBlank
  @Length(min = 1, max = 20)
  private String firstName;

  @Column(length = 20)
  private String secondName;

  @Column(nullable = false, length = 20)
  @NotBlank
  private String lastName;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "userLocationId", nullable = false)
  @NotNull
  private UserLocation userLocation;

  @OneToOne
  @JoinColumn(
    name = "userDocumentTypeId", 
    referencedColumnName = "userDocumentTypeId", 
    insertable = false, 
    updatable = false
  )
  private UserDocumentType userDocumentType;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "userContactId", referencedColumnName = "userContactId", nullable = false)
  @NotNull(message = "{validation.requiredField}")
  private UserContact userContact;
}
