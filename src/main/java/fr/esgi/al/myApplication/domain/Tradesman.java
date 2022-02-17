package fr.esgi.al.myApplication.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tradesman extends Membership {


    public Tradesman(UserId id, String firstName, String lastName, Date birthdate, boolean validate, Location address, List<Project> projects) {
        super(id, firstName, lastName, birthdate, validate, address, projects);
    }

    public static Tradesman newTradesman(UserId id, String firstName, String lastName, Date birthdate, Location address){
        return new Tradesman(id, firstName, lastName, birthdate, false, address, new ArrayList<>());
    }
}