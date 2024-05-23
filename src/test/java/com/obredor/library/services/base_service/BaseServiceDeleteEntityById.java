package com.obredor.library.services.base_service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.obredor.library.models.dtos.UserDTO;
import com.obredor.library.models.embeddables.UserId;
import com.obredor.library.models.entities.User;
import com.obredor.library.repositories.UserRepository;
import com.obredor.library.services.base.BaseService;

@ExtendWith(MockitoExtension.class)
public class BaseServiceDeleteEntityById {
  
  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private BaseService<User, UserDTO, UserId, UserRepository> baseService;

  

}
