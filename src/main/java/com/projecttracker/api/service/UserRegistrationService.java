package com.projecttracker.api.service;

import com.projecttracker.api.model.User;
import com.projecttracker.api.validator.UserLoginIdValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRegistrationService {

    private final UserService userService;
    private final UserLoginIdValidator userLoginIdValidator;

}

