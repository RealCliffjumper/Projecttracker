package com.projecttracker.api.repository;

import com.projecttracker.api.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public interface ProjectRepository extends JpaRepository<Project, UUID> {
    Optional<Project> findProjectByProjectId(UUID projectId);

    void deleteProjectByProjectId(UUID projectId);
    //@Transactional
    //@Modifying
    //@Query("UPDATE Project p" +
    // " SET p.status = 'completed' WHERE p.projectId = ?1" )
    //int completeProject(UUID projectId);
}
