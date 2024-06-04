package com.obredor.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obredor.library.models.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
  
}
