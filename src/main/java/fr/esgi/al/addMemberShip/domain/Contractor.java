package fr.esgi.al.addMemberShip.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contractor extends Membership{

    private List<Skills> skills;
    private float adr;
    private String job;

    private Contractor(UserId id, String firstName, String lastName, Date birthdate, boolean validate, Location address ,List<Project> projects, List<Skills> skills, float adr, String job) {
        super(id, firstName, lastName, birthdate, validate, address, projects);
        this.skills = skills;
        this.adr = adr;
        this.job = job;
    }

    public static Contractor newContractor(UserId id, String firstName, String lastName, Date birthdate, boolean validate, Location address){
        return new Contractor(id, firstName, lastName, birthdate, validate, address, new ArrayList<>(), new ArrayList<>(), 0, "");
    }

}
