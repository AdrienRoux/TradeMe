package fr.esgi.al.myApplication.application;

import fr.esgi.al.kernel.EventListener;

public class CreateContractorEventListener implements EventListener<CreateContractorEvent> {
    @Override
    public void listenTo(CreateContractorEvent event) {
        System.out.println("listening CreateUserEvent.");
    }
}
