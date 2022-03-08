package fr.esgi.al.education_certificate.exposition;

import fr.esgi.al.addMemberShip.domain.UserId;

import java.util.Date;

public class CertificationRequest {

    public String name;
    public Date date;
    public UserId ownerId;
    public String image;
    public boolean isValid;
}
