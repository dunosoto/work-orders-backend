package com.diplomado.workorder.repository;

import com.diplomado.workorder.domain.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
}
