package fr.esgi.al.education_certificate.application;

import fr.esgi.al.education_certificate.domain.CertificationRepository;
import fr.esgi.al.education_certificate.domain.EducationCertification;
import fr.esgi.al.education_certificate.domain.EducationCertificationId;
import fr.esgi.al.kernel.CommandHandler;
import fr.esgi.al.kernel.Event;
import fr.esgi.al.kernel.EventDispatcher;

public final class CreateCertificationCommandHandler  implements CommandHandler<CreateCertification, EducationCertificationId>  {

    private final CertificationRepository certificationRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateCertificationCommandHandler(CertificationRepository certificationRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.certificationRepository = certificationRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public EducationCertificationId handle(CreateCertification createCertification) {
        final EducationCertificationId educationCertificationId = certificationRepository.nextId();
        EducationCertification certification = EducationCertification.newEducationCertification(educationCertificationId, createCertification.name, createCertification.date,
                createCertification.ownerId, createCertification.image, createCertification.isValid);
        certificationRepository.save(certification);
        eventEventDispatcher.dispatch(new CreateCertificationEvent(educationCertificationId));
        return educationCertificationId;
    }
}
