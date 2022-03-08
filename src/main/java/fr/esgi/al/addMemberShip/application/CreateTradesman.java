package fr.esgi.al.addMemberShip.application;

import fr.esgi.al.kernel.Command;
import fr.esgi.al.addMemberShip.domain.Location;

import java.util.Date;

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