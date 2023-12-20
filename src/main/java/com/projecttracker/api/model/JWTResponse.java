package com.projecttracker.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class JWTResponse {

    private User user;
    private String jwtToken;
}
