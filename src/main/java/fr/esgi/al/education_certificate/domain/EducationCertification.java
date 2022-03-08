package fr.esgi.al.education_certificate.domain;

import fr.esgi.al.addMemberShip.domain.UserId;

import java.util.Date;

public class EducationCertification {

    private EducationCertificationId id;
    private String name;
    private Date date;
    private UserId ownerId;
    private String image;
    private boolean isValid;

    public EducationCertification(EducationCertificationId id, String name, Date date, UserId ownerId, String image, boolean isValid) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.ownerId = ownerId;
        this.image = image;
        this.isValid = isValid;
    }

    public static EducationCertification newEducationCertification(EducationCertificationId id, String name, Date date, UserId ownerId, String image, boolean isValid){
        return new EducationCertification( id, name, date, ownerId, image, isValid);
    }

    public EducationCertificationId getId() {
        return id;
    }
}
