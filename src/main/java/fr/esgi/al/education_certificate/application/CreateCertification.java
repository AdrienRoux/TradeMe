package fr.esgi.al.education_certificate.application;

import fr.esgi.al.kernel.Command;
import fr.esgi.al.addMemberShip.domain.UserId;

import java.util.Date;

public final class CreateCertification implements Command {


    public final String name;
    public final Date date;
    public final UserId ownerId;
    public final String image;
    public final boolean isValid;

    public CreateCertification(String name, Date date, UserId ownerId, String image, boolean isValid) {
        this.name = name;
        this.date = date;
        this.ownerId = ownerId;
        this.image = image;
        this.isValid = isValid;
    }
}
