package fr.esgi.al.myApplication.project.domain.repository;



import fr.esgi.al.kernel.Repository;
import fr.esgi.al.myApplication.project.domain.model.Project;
import fr.esgi.al.myApplication.project.domain.model.ProjectId;


import java.util.List;

public interface ProjectRepository extends Repository<ProjectId, Project> {
    List<Project> findAll();
}
