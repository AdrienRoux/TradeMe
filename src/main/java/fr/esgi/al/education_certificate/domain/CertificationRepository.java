package fr.esgi.al.education_certificate.domain;

import java.util.UUID;

public interface CertificationRepository {

    void save(EducationCertification educationCertification);

    EducationCertification byId(EducationCertificationId userId);

    default EducationCertificationId nextId() {
        return EducationCertificationId.fromUUID(UUID.randomUUID());
    }
}
