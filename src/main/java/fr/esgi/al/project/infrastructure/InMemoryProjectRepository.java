package fr.esgi.al.project.infrastructure;


import fr.esgi.al.kernel.NoSuchEntityException;
import fr.esgi.al.project.domain.model.Project;
import fr.esgi.al.project.domain.model.ProjectId;
import fr.esgi.al.project.domain.repository.ProjectRepository;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryProjectRepository implements ProjectRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<ProjectId, Project> data = new ConcurrentHashMap<>();

    @Override
    public List<Project> findAll() {
        return List.copyOf(data.values());
    }

    @Override
    public ProjectId nextIdentity() {
        return new ProjectId(count.incrementAndGet());
    }

    @Override
    public Project findById(ProjectId id) throws NoSuchEntityException {
        return null;
    }

    @Override
    public void add(Project project) {
        data.put(project.getId(), project);
    }

    @Override
    public void delete(ProjectId id) {
        data.remove(id);
    }
}
