package fr.esgi.al.education_certificate.application;

import fr.esgi.al.education_certificate.domain.EducationCertificationId;
import fr.esgi.al.kernel.ApplicationEvent;

public class CreateCertificationEvent implements ApplicationEvent {
    private final EducationCertificationId educationCertificationId;

    public CreateCertificationEvent(EducationCertificationId educationCertificationId) {
        this.educationCertificationId = educationCertificationId;
    }

    public EducationCertificationId getEducationCertificationId() {
        return educationCertificationId;
    }
}
