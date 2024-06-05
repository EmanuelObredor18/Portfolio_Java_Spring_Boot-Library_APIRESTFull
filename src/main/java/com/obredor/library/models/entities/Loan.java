package com.obredor.library.models.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "LOANS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Loan implements BaseEntity<Long> {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long loanId;

  @Column(nullable = false)
  @Temporal(TemporalType.DATE)
  private Date startLoanDate;

  @Column(nullable = false)
  private Date finishLoanDate;

  @ManyToOne
  @JoinColumns({
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false),
    @JoinColumn(name = "userDocumentTypeId", referencedColumnName = "userDocumentTypeId", nullable = false)
  })
  private User user;

  @ManyToOne
  @JoinColumn(name = "bookIsbn", referencedColumnName = "bookIsbn", nullable = false)
  private Book book;

  @Override
  public Long getId() {
    return this.loanId;
  }
}

