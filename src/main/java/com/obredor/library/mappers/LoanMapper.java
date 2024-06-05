package com.obredor.library.mappers;

import org.springframework.stereotype.Component;

import com.obredor.library.mappers.base.GenericMapper;
import com.obredor.library.models.dtos.LoanDTO;
import com.obredor.library.models.entities.Loan;

@Component
public class LoanMapper extends GenericMapper<Loan, LoanDTO> {
  
}
