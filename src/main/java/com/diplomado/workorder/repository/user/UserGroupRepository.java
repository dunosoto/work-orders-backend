package com.diplomado.workorder.repository.user;


import com.diplomado.workorder.domain.user.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
}
