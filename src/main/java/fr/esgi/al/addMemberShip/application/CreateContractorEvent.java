package fr.esgi.al.addMemberShip.application;

import fr.esgi.al.kernel.ApplicationEvent;
import fr.esgi.al.addMemberShip.domain.UserId;

public class CreateContractorEvent implements ApplicationEvent {
    private final UserId userId;

    public CreateContractorEvent(UserId userId) {
        this.userId = userId;
    }
}