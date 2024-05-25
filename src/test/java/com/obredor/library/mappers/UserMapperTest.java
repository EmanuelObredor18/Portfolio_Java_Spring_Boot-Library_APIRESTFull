package com.obredor.library.mappers;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.obredor.library.models.dtos.UserDTO;
import com.obredor.library.models.embeddables.UserId;
import com.obredor.library.models.entities.User;
import com.obredor.library.models.entities.UserDocumentType;

@SpringBootTest
public class UserMapperTest {
  
  @Autowired
  private ModelMapper modelMapper;

  @Test
  public void toEntity() {
    UserDTO userDTO = UserDTO.builder()
        .firstName("Emanuel")
        .secondName("Jesus")
        .lastName("Obredor")
        .userDocumentTypeId("CC")
        .userId("1043662882")
        .build();

    User user = User.builder()
      .firstName("Emanuel")
      .secondName("Jesus")
      .lastName("Obredor")
      .userId(new UserId("1043662882", "CC"))
      .userDocumentType(new UserDocumentType("CC", null))
      .build();

    assertEquals(user, modelMapper.map(userDTO, User.class));
  } 

}
