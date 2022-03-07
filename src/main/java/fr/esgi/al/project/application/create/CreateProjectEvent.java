package fr.esgi.al.project.application.create;

import fr.esgi.al.kernel.ApplicationEvent;
import fr.esgi.al.project.domain.model.ProjectId;

public class CreateProjectEvent implements ApplicationEvent {
    private final ProjectId projectId;

    public CreateProjectEvent(ProjectId projectId) {
        this.projectId = projectId;
    }
}