package fr.esgi.al;

import fr.esgi.al.education_certificate.application.CreateCertificationCommandHandler;
import fr.esgi.al.education_certificate.application.CreateCertificationEvent;
import fr.esgi.al.education_certificate.application.CreateCertificationEventListner;
import fr.esgi.al.education_certificate.domain.CertificationRepository;
import fr.esgi.al.education_certificate.infrastructure.InMemoryCertificationRepository;
import fr.esgi.al.kernel.*;
import fr.esgi.al.addMemberShip.application.*;
import fr.esgi.al.addMemberShip.domain.UserRepository;
import fr.esgi.al.addMemberShip.infrastructure.DefaultEventDispatcher;
import fr.esgi.al.addMemberShip.infrastructure.InMemoryUserRepository;
import fr.esgi.al.project.application.create.CreateProjectCommandHandler;
import fr.esgi.al.project.application.create.CreateProjectEvent;
import fr.esgi.al.project.application.create.CreateProjectEventListener;
import fr.esgi.al.project.domain.repository.ProjectRepository;
import fr.esgi.al.project.infrastructure.InMemoryProjectRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class UserConfiguration {

    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    public ProjectRepository projectRepository() {
        return new InMemoryProjectRepository();
    }

    @Bean
    public CertificationRepository certificationRepository() {
        return new InMemoryCertificationRepository();
    }

    @Bean
    public CreateProjectCommandHandler createProjectCommandHandler() {
        return new CreateProjectCommandHandler(projectRepository(), eventEventDispatcher());
    }

    @Bean
    public CreateCertificationCommandHandler createCertificationCommandHandler() {
        return new CreateCertificationCommandHandler(certificationRepository(), eventEventDispatcher());
    }

    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreateContractorEvent.class, List.of(new CreateContractorEventListener()));
        listenerMap.put(CreateTradesmanEvent.class, List.of(new CreateTradesmanEventListener()));
        listenerMap.put(CreateProjectEvent.class, List.of(new CreateProjectEventListener()));
        listenerMap.put(CreateCertificationEvent.class, List.of(new CreateCertificationEventListner()));

        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public CreateContractorCommandHandler createContractorCommandHandler() {
        return new CreateContractorCommandHandler(userRepository(), eventEventDispatcher());
    }

    @Bean
    public CreateTradesmanCommandHandler createTradesmanCommandHandler() {
        return new CreateTradesmanCommandHandler(userRepository(), eventEventDispatcher());
    }

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(CreateContractor.class, new CreateContractorCommandHandler(userRepository(), eventEventDispatcher()));
        commandHandlerMap.put(CreateTradesman.class, new CreateTradesmanCommandHandler(userRepository(), eventEventDispatcher()));
        return new SimpleCommandBus(commandHandlerMap);
    }

}
