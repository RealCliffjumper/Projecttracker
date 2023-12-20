package com.projecttracker.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JWTRequest {

    private String userLoginId;
    private String password;
}
