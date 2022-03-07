package fr.esgi.al.project.application.create;


import fr.esgi.al.kernel.CommandHandler;
import fr.esgi.al.kernel.Event;
import fr.esgi.al.kernel.EventDispatcher;
import fr.esgi.al.project.domain.model.Owner;
import fr.esgi.al.project.domain.model.Project;
import fr.esgi.al.project.domain.model.ProjectId;
import fr.esgi.al.project.domain.repository.ProjectRepository;


public class CreateProjectCommandHandler implements CommandHandler<CreateProject, ProjectId> {

    private final ProjectRepository projectRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateProjectCommandHandler(ProjectRepository projectRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.projectRepository = projectRepository;
        this.eventEventDispatcher = eventEventDispatcher;

    }

    @Override
    public ProjectId handle(CreateProject createProject) {
        final ProjectId projectId = projectRepository.nextIdentity();
        Project project = Project.of(projectId, createProject.name, new Owner(createProject.owner.getName()), createProject.status);
        projectRepository.add(project);
        eventEventDispatcher.dispatch(new CreateProjectEvent(projectId));
        return projectId;
    }
}
