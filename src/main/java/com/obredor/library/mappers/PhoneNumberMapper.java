package com.obredor.library.mappers;

import org.springframework.stereotype.Component;

import com.obredor.library.mappers.base.GenericMapper;
import com.obredor.library.models.dtos.PhoneNumberDTO;
import com.obredor.library.models.entities.PhoneNumber;

@Component
public class PhoneNumberMapper extends GenericMapper<PhoneNumber, PhoneNumberDTO> {
  
}
