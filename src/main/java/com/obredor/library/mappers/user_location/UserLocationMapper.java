package com.obredor.library.mappers.user_location;

import org.springframework.stereotype.Component;

import com.obredor.library.mappers.base.GenericMapper;
import com.obredor.library.models.dtos.UserLocationDTO;
import com.obredor.library.models.entities.UserLocation;

@Component
public class UserLocationMapper extends GenericMapper<UserLocation, UserLocationDTO> {
  
}
