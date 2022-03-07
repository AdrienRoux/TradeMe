package fr.esgi.al.addMemberShip.application;

import fr.esgi.al.kernel.EventListener;

public class CreateTradesmanEventListener implements EventListener<CreateTradesmanEvent> {
    @Override
    public void listenTo(CreateTradesmanEvent event) {
        System.out.println("listening CreateUserEvent.");
    }
}
