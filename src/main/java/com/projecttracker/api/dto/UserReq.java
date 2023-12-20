package com.projecttracker.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserReq implements Serializable {

    private String userFirstName;
    private String userLastName;
    private String userLoginId;
    private String password;

}
