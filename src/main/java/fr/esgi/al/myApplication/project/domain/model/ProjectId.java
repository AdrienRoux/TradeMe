package fr.esgi.al.myApplication.project.domain.model;

import fr.esgi.al.kernel.ValueObjectID;

import java.util.Objects;

public final class ProjectId implements ValueObjectID {
    private final int value;

    public ProjectId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectId projectId = (ProjectId) o;
        return value == projectId.value;
    }

    @Override
    public int hashCode() { return Objects.hash(value); }
}
