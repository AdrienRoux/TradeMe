package fr.esgi.al.myApplication.application;

import fr.esgi.al.kernel.ApplicationEvent;
import fr.esgi.al.myApplication.domain.UserId;

public class CreateContractorEvent implements ApplicationEvent {
    private final UserId userId;

    public CreateContractorEvent(UserId userId) {
        this.userId = userId;
    }
}