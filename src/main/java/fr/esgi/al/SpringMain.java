package fr.esgi.al;

import fr.esgi.al.education_certificate.application.CreateCertification;
import fr.esgi.al.education_certificate.application.CreateCertificationCommandHandler;
import fr.esgi.al.education_certificate.domain.EducationCertificationId;
import fr.esgi.al.addMemberShip.domain.UserId;
import fr.esgi.al.project.application.create.CreateProject;
import fr.esgi.al.project.application.create.CreateProjectCommandHandler;
import fr.esgi.al.project.domain.model.Owner;
import fr.esgi.al.project.domain.model.ProjectId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class SpringMain {
    public static void main(String[] args) {
        //System.setProperty("spring.profiles.default", "dev");

        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMain.class, args);

        CreateCertificationCommandHandler createCertificationCommandHandler = applicationContext.getBean(CreateCertificationCommandHandler.class);
        CreateCertification createCertification = new CreateCertification("cocuocy", new Date(2022, 03, 14), UserId.fromUUID(new UUID(15,15)), "imùage", false);
        final EducationCertificationId educationCertificationId = createCertificationCommandHandler.handle(createCertification);
        final EducationCertificationId educationCertificationId3 = createCertificationCommandHandler.handle(createCertification);

        System.out.println("listening CreateCertification." + educationCertificationId.getValue() + educationCertificationId3.getValue());
        //--2. Create Project
        CreateProjectCommandHandler projectCommandHandler = applicationContext.getBean(CreateProjectCommandHandler.class);
        CreateProject createProject = new CreateProject("VW Bank", new Owner("Volkswagen Financial Services"), "On Going", LocalDate.of(2022, 03, 14), LocalDate.of(2022, 12, 31) );
        final ProjectId projectId = projectCommandHandler.handle(createProject);



    }
}