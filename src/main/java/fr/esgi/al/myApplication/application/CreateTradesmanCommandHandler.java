package fr.esgi.al.myApplication.application;

import fr.esgi.al.kernel.CommandHandler;
import fr.esgi.al.kernel.Event;
import fr.esgi.al.kernel.EventDispatcher;
import fr.esgi.al.myApplication.domain.*;


public final class CreateTradesmanCommandHandler implements CommandHandler<CreateTradesman, UserId> {

    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateTradesmanCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userRepository = userRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public UserId handle(CreateTradesman createUser) {
        final UserId userId = userRepository.nextId();
        Membership user = Tradesman.newTradesman(userId, createUser.lastName, createUser.firstName, createUser.birthdate,
                new Location(createUser.address.getAddress(),createUser.address.getCity()) );
        userRepository.save(user);
        eventEventDispatcher.dispatch(new CreateContractorEvent(userId));
        return userId;
    }
}