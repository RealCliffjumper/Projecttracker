package com.projecttracker.api.repository;

import com.projecttracker.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@Transactional//(readOnly = true)
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUserLoginId(String userLoginId);

    void deleteUserByUserLoginId(String userLoginId);
}
