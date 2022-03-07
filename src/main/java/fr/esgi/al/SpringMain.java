package fr.esgi.al;

import fr.esgi.al.myApplication.application.CreateContractor;
import fr.esgi.al.myApplication.application.CreateContractorCommandHandler;
import fr.esgi.al.myApplication.domain.Location;
import fr.esgi.al.myApplication.domain.UserId;
import fr.esgi.al.myApplication.project.application.create.CreateProject;
import fr.esgi.al.myApplication.project.application.create.CreateProjectCommandHandler;
import fr.esgi.al.myApplication.project.domain.model.Owner;
import fr.esgi.al.myApplication.project.domain.model.ProjectId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class SpringMain {
    public static void main(String[] args) {
        //System.setProperty("spring.profiles.default", "dev");

        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMain.class, args);

        
        //--2. Create Project
        CreateProjectCommandHandler projectCommandHandler = applicationContext.getBean(CreateProjectCommandHandler.class);
        CreateProject createProject = new CreateProject("VW Bank", new Owner("Volkswagen Financial Services"), "On Going", LocalDate.of(2022, 03, 14), LocalDate.of(2022, 12, 31) );
        final ProjectId projectId = projectCommandHandler.handle(createProject);

    }
}