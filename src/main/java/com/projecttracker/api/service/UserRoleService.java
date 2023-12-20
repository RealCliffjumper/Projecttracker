package com.projecttracker.api.service;


import com.projecttracker.api.model.User;
import com.projecttracker.api.model.UserRole;
import com.projecttracker.api.model.UserRolePK;
import com.projecttracker.api.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Transactional
    public UserRole createUserRole(User user, String roleName){
        UserRole userRole = new UserRole();
        UserRolePK userRolePK = new UserRolePK();
        userRolePK.setRoleName(roleName);
        userRolePK.setUserId(user.getUserId());
        userRole.setId(userRolePK);
        return userRoleRepository.save(userRole);
    }
}
