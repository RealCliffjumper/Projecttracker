package com.projecttracker.api.controller;

import com.projecttracker.api.model.JWTRequest;
import com.projecttracker.api.model.JWTResponse;
import com.projecttracker.api.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JWTController {

    @Autowired
    JWTService jwtService;

    @PostMapping("/auth")
    public JWTResponse createJwtToken(@RequestBody JWTRequest jwtRequest) throws Exception{
        return jwtService.createJwtToken(jwtRequest);
    }
}
