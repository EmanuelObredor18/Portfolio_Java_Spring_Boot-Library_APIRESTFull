package com.obredor.library.models.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "USER_CONTACTS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserContact implements BaseEntity<Long> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userContactId;

  @Column(length = 35)
  private String email;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumns({
    @JoinColumn(name = "number", referencedColumnName = "number", nullable = false),
    @JoinColumn(name = "prefixId", referencedColumnName = "prefixId", nullable = false)
  })
  private PhoneNumber phoneNumber;

  @OneToOne(mappedBy = "userContact")
  private User user;

  @Override
  public Long getId() {
    return this.userContactId;
  }
}
