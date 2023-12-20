package com.projecttracker.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Enumerated(EnumType.STRING)
    @Id
    private ERole roleName;
    private String roleDescription;
}
