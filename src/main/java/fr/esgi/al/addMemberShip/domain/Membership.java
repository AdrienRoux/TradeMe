package fr.esgi.al.addMemberShip.domain;

import java.util.Date;
import java.util.List;

public abstract class Membership {

    private UserId id;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private boolean validate;
    private Location address;
    private List<Project> projects;

    public Membership( UserId userId, String firstName, String lastName, Date birthdate, boolean validate, Location address, List<Project> projects) {
        this.id = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.validate = validate;
        this.address = address;
        this.projects = projects;
    }

    public UserId getId() {
        return id;
    }

    public void setId(UserId id) {
        this.id = id;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }


}
