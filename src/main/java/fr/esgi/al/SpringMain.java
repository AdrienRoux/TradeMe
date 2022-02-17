package fr.esgi.al;

import fr.esgi.al.myApplication.application.CreateContractor;
import fr.esgi.al.myApplication.application.CreateContractorCommandHandler;
import fr.esgi.al.myApplication.domain.Location;
import fr.esgi.al.myApplication.domain.UserId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class SpringMain {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMain.class, args);

        //--1. Create Contractor
        CreateContractorCommandHandler userCommandHandler = applicationContext.getBean(CreateContractorCommandHandler.class);
            CreateContractor createUser = new CreateContractor("azerty", "ytreza",
                    new Date(1997, 9, 22), false,
                    new Location("7 rue de la paix", "PARIS"), new ArrayList<>(), new ArrayList<>(), 0, "azerty");
        final UserId userId = userCommandHandler.handle(createUser);
    }
}