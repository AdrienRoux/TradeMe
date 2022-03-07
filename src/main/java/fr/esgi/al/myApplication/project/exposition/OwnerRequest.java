package fr.esgi.al.myApplication.project.exposition;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OwnerRequest {
    @NotNull
    @NotBlank
    public String name;
}
