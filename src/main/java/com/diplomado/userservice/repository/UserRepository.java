package com.diplomado.userservice.repository;

import com.diplomado.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  
  Optional<User> findById(Long Id);
  void delete(User user);
  
  @Transactional
  @Modifying
  @Query(value = "UPDATE User user SET user.userName=:newUserName WHERE user.id=:userId")
  User updateUserNameByUserId(@Param("newUserName") String newUserName, @Param("userId") Long userId);
  
}
