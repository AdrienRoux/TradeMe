package fr.esgi.al.myApplication.application;

import fr.esgi.al.kernel.CommandHandler;
import fr.esgi.al.kernel.Event;
import fr.esgi.al.kernel.EventDispatcher;
import fr.esgi.al.myApplication.domain.*;

public final class CreateContractorCommandHandler implements CommandHandler<CreateContractor, UserId> {

    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateContractorCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userRepository = userRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public UserId handle(CreateContractor createUser) {
        final UserId userId = userRepository.nextId();
        Membership user = Contractor.newContractor(userId, createUser.lastName, createUser.firstName, createUser.birthdate,
                false, new Location(createUser.address.getAddress(),createUser.address.getCity()) );
        userRepository.save(user);
        eventEventDispatcher.dispatch(new CreateContractorEvent(userId));
        return userId;
    }
}