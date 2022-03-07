package fr.esgi.al.addMemberShip.domain;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private List<String> jobs;
    private List<Skills> skills;
    private Location address;
    private Float adrWished;
    private Membership owner;
    private List<Membership> workers;

    public Project(List<String> jobs, List<Skills> skills, Location address, Float adrWished, Membership owner, List<Membership> workers) {
        this.jobs = jobs;
        this.skills = skills;
        this.address = address;
        this.adrWished = adrWished;
        this.owner = owner;
        this.workers = new ArrayList<>();
    }
}
