package com.obredor.library.services;
import org.springframework.stereotype.Service;

import com.obredor.library.mappers.UserMapper;
import com.obredor.library.models.dtos.UserDTO;
import com.obredor.library.models.embeddables.UserId;
import com.obredor.library.models.entities.User;
import com.obredor.library.repositories.UserRepository;
import com.obredor.library.services.base.BaseService;

@Service
public class UserService extends BaseService<User, UserDTO, UserId, UserRepository> {

  public UserService(UserRepository repository, UserMapper mapper) {
    super(repository, mapper);
  }

}
