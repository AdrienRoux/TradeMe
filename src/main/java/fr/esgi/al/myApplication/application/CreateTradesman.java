package fr.esgi.al.myApplication.application;

import fr.esgi.al.kernel.Command;
import fr.esgi.al.myApplication.domain.Location;
import fr.esgi.al.myApplication.domain.Project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class CreateTradesman implements Command {

    public final String firstName;
    public final String lastName;
    public final Date birthdate;
    public final boolean validate;
    public final Location address;



    public CreateTradesman(String firstName, String lastName,
                            Date birthdate, boolean validate,
                            Location address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.validate = validate;
        this.address = address;
    }
}