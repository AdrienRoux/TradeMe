package fr.esgi.al.myApplication.project.application.create;

import fr.esgi.al.kernel.EventListener;

public class CreateProjectEventListener implements EventListener<CreateProjectEvent> {
    @Override
    public void listenTo(CreateProjectEvent event) { System.out.println("listening CreateProjectEvent."); }
}
