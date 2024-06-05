package com.obredor.library.mappers.user;

import org.springframework.stereotype.Component;

import com.obredor.library.mappers.base.GenericMapper;
import com.obredor.library.models.dtos.UserContactDTO;
import com.obredor.library.models.entities.UserContact;

@Component
public class UserContactMapper extends GenericMapper<UserContact, UserContactDTO> {
  
}
