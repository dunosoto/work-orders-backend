package com.diplomado.workorder.repository.user;

import com.diplomado.workorder.domain.user.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
}
