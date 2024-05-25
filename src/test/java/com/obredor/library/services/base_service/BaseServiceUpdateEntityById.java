package com.obredor.library.services.base_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.obredor.library.errors.exceptions.EntityNotFoundException;
import com.obredor.library.mappers.UserMapper;
import com.obredor.library.models.dtos.UserDTO;
import com.obredor.library.models.embeddables.UserId;
import com.obredor.library.models.entities.User;
import com.obredor.library.repositories.UserRepository;
import com.obredor.library.services.base.BaseService;

@ExtendWith(MockitoExtension.class)
public class BaseServiceUpdateEntityById {
  
  @Mock
  private UserRepository userRepository;

  @Mock
  private UserMapper userMapper;

  @InjectMocks
  private BaseService<User, UserDTO, UserId, UserRepository> baseService;

  @Test
  public void updateEntityHappy() {

    User user = User.builder()
        .userId(new UserId("1043662882", "CC"))
        .firstName("Emanuel")
        .secondName("Jesus")
        .lastName("Obredor")
        .build();

    UserDTO userDTO = UserDTO.builder()
        .userId("1043662882")
        .userDocumentTypeId("CC")
        .firstName("Emanuel")
        .secondName("Jesus")
        .lastName("Obredor")
        .build();
    
    when(userRepository.findById(any())).thenReturn(Optional.of(user));

    when(userMapper.toDto(any())).thenReturn(userDTO);
    
    when(userRepository.save(any())).thenReturn(user);
    
    when(userMapper.toEntity(userDTO)).thenReturn(user);

    assertEquals(userDTO, baseService.updateEntity(user));
  }

  @Test
  public void updateEntityNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      baseService.updateEntity(null);
    });
  }

  @Test
  public void updateEntityIsNotFound() {
    when(userRepository.findById(any())).thenReturn(Optional.empty());
    assertThrows(EntityNotFoundException.class, () -> {
      baseService.updateEntity(User.builder().userId(new UserId()).build());
    });
  }
}
