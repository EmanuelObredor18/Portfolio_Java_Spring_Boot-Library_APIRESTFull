package com.obredor.library.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obredor.library.models.embeddables.UserId;
import com.obredor.library.models.entities.User;

public interface UserRepository extends JpaRepository<User, UserId> {
  
}
