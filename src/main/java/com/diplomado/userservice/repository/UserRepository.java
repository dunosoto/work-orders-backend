package com.diplomado.userservice.repository;

import com.diplomado.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  
  Optional<User> findById(Long Id);
  void delete(User user);
}
