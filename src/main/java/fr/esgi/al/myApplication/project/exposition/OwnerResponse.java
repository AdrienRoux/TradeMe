package fr.esgi.al.myApplication.project.exposition;

@SuppressWarnings("all")
public class OwnerResponse {

    public String name;

    public OwnerResponse(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProjectResponse{" +
                ", name='" + name + '\'' +
                '}';
    }
}
