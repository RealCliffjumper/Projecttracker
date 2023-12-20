package com.projecttracker.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private UUID projectId;
    private String projectName;
    private int projectDevs;
    private LocalDateTime createdAt;
    //private LocalDateTime completedAt;
    private int userHrs;
    private String usersWorking;
    private @Column(nullable = false, unique = true) String projectCode;
    //private String[] status = {"completed", "postponed", "active", "terminated"};

    @ManyToMany(mappedBy = "projects")
    private Set<User> userSet;

    public Project(String projectName,
                   int projectDevs,
                   LocalDateTime createdAt,
                   int userHrs,
                   String usersWorking) {
        this.projectName = projectName;
        this.projectDevs = projectDevs;
        this.createdAt = LocalDateTime.now();
        this.userHrs = userHrs;
        this.usersWorking = usersWorking;
    }
    
    public String getProjectName() {
        return projectName;
    }

    public int getProjectDevs() {
        return projectDevs;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    //public LocalDateTime getCompletedAt() {
      //  return completedAt;
    //}

    public int getUserHrs() {
        return userHrs;
    }

    public String getUsersWorking() {
        return usersWorking;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + projectId +
                ", name='" + projectName + '\'' +
                ", project devs='" + projectDevs + '\'' +
                ", userHRs='" + userHrs + '\'' +
                ", usersWorking= '" + usersWorking + '\'' +
                '}';
    }
}
