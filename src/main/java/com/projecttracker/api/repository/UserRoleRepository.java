package com.projecttracker.api.repository;

import com.projecttracker.api.model.UserRole;
import com.projecttracker.api.model.UserRolePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRolePK> {
}
