package fr.esgi.al.project.exposition;

import java.util.List;

public class ProjectsResponse {
    public final List<ProjectResponse> projects;

    public ProjectsResponse(List<ProjectResponse> projects) {
        this.projects = projects;
    }
}
