package fr.esgi.al.education_certificate.application;

import fr.esgi.al.kernel.EventListener;

public class CreateCertificationEventListner implements EventListener<CreateCertificationEvent> {
    @Override
    public void listenTo(CreateCertificationEvent event) {
        System.out.println("Certification created, new id : " + event.getEducationCertificationId().getValue());
    }
}
