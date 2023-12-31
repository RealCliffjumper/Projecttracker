package com.projecttracker.api.controller;

import com.projecttracker.api.model.Role;
import com.projecttracker.api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/createRole")
    public Role createNewRole(@RequestBody Role role){

        return roleService.createNewRole(role);

    }
}
