package fr.esgi.al.myApplication.application;

import fr.esgi.al.kernel.ApplicationEvent;
import fr.esgi.al.myApplication.domain.UserId;

public class CreateTradesmanEvent implements ApplicationEvent {
    private final UserId userId;

    public CreateTradesmanEvent(UserId userId) {
        this.userId = userId;
    }
}
