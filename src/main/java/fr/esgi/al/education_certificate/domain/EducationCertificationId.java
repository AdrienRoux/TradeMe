package fr.esgi.al.education_certificate.domain;

import java.util.UUID;

public class EducationCertificationId {

    private final String value;

    private EducationCertificationId(String value) {
        this.value = value;
    }

    public static EducationCertificationId fromUUID(UUID uuid) {
        return new EducationCertificationId(uuid.toString());
    }

    public static EducationCertificationId of(String value) {
        return new EducationCertificationId(value);
    }

    public String getValue() {
        return value;
    }

}
