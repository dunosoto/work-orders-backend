package com.diplomado.userservice.repository;

import com.diplomado.userservice.domain.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
}
