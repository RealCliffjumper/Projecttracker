package com.projecttracker.api.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @Column(nullable = false, updatable = false)
    private  UUID userId;
    private String userFirstName;
    private String userLastName;
    private @Column(nullable = false, unique = true) String userLoginId;
    private String password;
    private Boolean isNonLocked = true;
    private Boolean isEnabled = true;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
    joinColumns = {
            @JoinColumn(name = "USER_ID")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "ROLE_NAME")
    })
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_PROJECT",
    joinColumns = {
            @JoinColumn(name = "USER_ID")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "PROJECT_ID")
    })
    private Set<Project> projects;

    public User(String userFirstName,
                String userLastName,
                String userLoginId,
                String password) {
        this.userId = UUID.randomUUID();
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userLoginId = userLoginId;
        this.password = password;
    }
}
