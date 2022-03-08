package fr.esgi.al.education_certificate.infrastructure;

import fr.esgi.al.education_certificate.domain.CertificationRepository;
import fr.esgi.al.education_certificate.domain.EducationCertification;
import fr.esgi.al.education_certificate.domain.EducationCertificationId;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryCertificationRepository implements CertificationRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<EducationCertificationId, EducationCertification> data = new ConcurrentHashMap<>();

    @Override
    public void save(EducationCertification educationCertification) {
        data.put(educationCertification.getId(), educationCertification);
    }


    @Override
    public EducationCertification byId(EducationCertificationId educationCertificationId) {
        final EducationCertification membership = data.get(educationCertificationId);
        if (membership == null) {
            throw new RuntimeException("No user for " + educationCertificationId.getValue());
        }
        return membership;
    }

    @Override
    public EducationCertificationId nextId() {
        return EducationCertificationId.of(String.valueOf(counter.incrementAndGet()));
    }
}
