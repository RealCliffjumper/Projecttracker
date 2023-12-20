package com.projecttracker.api.service;

import com.projecttracker.api.exception.ProjectNotFoundException;
import com.projecttracker.api.model.Project;
import com.projecttracker.api.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service("projectTrackerProjectService")
@AllArgsConstructor
@Transactional
public class ProjectService {
    private final ProjectRepository projectRepository;

    public Project addProject(Project project){
            project.setProjectCode(UUID.randomUUID().toString());
            project.setCreatedAt(LocalDateTime.now());
            project.setProjectDevs(1);
            //project.setUsersWorking(user.userFirstName+user.userLastName);
        return projectRepository.save(project);
    }

    public List<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public Project updateProject(Project project){
        return projectRepository.save(project);
    }

    public Project findProjectByProjectId(UUID projectId){
        return projectRepository.findProjectByProjectId(projectId)
                .orElseThrow(() -> new ProjectNotFoundException("Project by id %projectId not found"));
    }

    public void deleteProject(UUID projectId){
        projectRepository.deleteProjectByProjectId(projectId);
    }

    //public int completeProject(UUID projectId){
       // return projectRepository.completeProject;
   // }
}
