package fr.esgi.al;

import fr.esgi.al.kernel.*;
import fr.esgi.al.myApplication.application.*;
import fr.esgi.al.myApplication.domain.UserRepository;
import fr.esgi.al.myApplication.infrastructure.DefaultEventDispatcher;
import fr.esgi.al.myApplication.infrastructure.InMemoryUserRepository;
import fr.esgi.al.myApplication.project.application.create.CreateProjectCommandHandler;
import fr.esgi.al.myApplication.project.application.create.CreateProjectEvent;
import fr.esgi.al.myApplication.project.application.create.CreateProjectEventListener;
import fr.esgi.al.myApplication.project.domain.repository.ProjectRepository;
import fr.esgi.al.myApplication.project.infrastructure.InMemoryProjectRepository;
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
    public CreateProjectCommandHandler createProjectCommandHandler() {
        return new CreateProjectCommandHandler(projectRepository(), eventEventDispatcher());
    }

    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreateContractorEvent.class, List.of(new CreateContractorEventListener()));
        listenerMap.put(CreateTradesmanEvent.class, List.of(new CreateTradesmanEventListener()));
        listenerMap.put(CreateProjectEvent.class, List.of(new CreateProjectEventListener()));

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
