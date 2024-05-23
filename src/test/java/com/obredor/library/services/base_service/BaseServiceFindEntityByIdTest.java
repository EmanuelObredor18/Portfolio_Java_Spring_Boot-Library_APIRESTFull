package com.obredor.library.services.base_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
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
public class BaseServiceFindEntityByIdTest {

  @Mock
  private UserRepository userRepository;

  @Mock
  private UserMapper userMapper;

  @InjectMocks
  private BaseService<User, UserDTO, UserId, UserRepository> baseService;

  private User user;

  private UserDTO userDTO;

  @BeforeEach
  public void setUp() {
    user = User.builder()
        .firstName("Emanuel")
        .secondName("Jesus")
        .lastName("Obredor")
        .build();

    userDTO = UserDTO.builder()
        .firstName("Emanuel")
        .secondName("Jesus")
        .lastName("Obredor")
        .build();

  }

  @Test
  public void getEntityByIdTest() {
    when(userRepository.findById(any())).thenReturn(Optional.of(user));
    when(userMapper.toDto(any(User.class))).thenReturn(userDTO);
    UserDTO userDto = UserDTO.builder()
        .firstName("Emanuel")
        .secondName("Jesus")
        .lastName("Obredor")
        .build();

    assertEquals(userDto, baseService.getEntityById(new UserId()));
  }

  @Test
  public void getEntityByIdNullTest() {
    assertThrows(IllegalArgumentException.class, () -> {
      baseService.getEntityById(null);
    });
  }

  @Test
  public void getEntityByIdNotFoundTest() {

    when(userRepository.findById(any())).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> {
      baseService.getEntityById(new UserId());
    });
  }

}
