package com.projecttracker.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class UserProjectPK implements Serializable {
        @Column(name = "user_id")
        private UUID userId;
        @Column(name = "project_id")
        private UUID projectId;
        @Column(name = "user_project_role")
        private String roleName;
}
