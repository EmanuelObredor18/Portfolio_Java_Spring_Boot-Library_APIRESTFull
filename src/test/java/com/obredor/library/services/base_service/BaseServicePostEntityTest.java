package com.obredor.library.services.base_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
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
public class BaseServicePostEntityTest {
  
  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private BaseService<User, UserDTO, UserId, UserRepository> baseService;

  @Test
  public void happyPostEntityTest() {
    when(userRepository.save(any())).thenReturn(new User());
    assertEquals("Entity saved successfully", baseService.post(new User()));
  }

  @Test
  @SuppressWarnings("null")
  public void postEntityNull() {
    when(userRepository.save(null)).thenThrow(new IllegalArgumentException());

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      baseService.post(null);
    });

    assertEquals("The entity ID cannot be null", exception.getMessage());
  }

}
