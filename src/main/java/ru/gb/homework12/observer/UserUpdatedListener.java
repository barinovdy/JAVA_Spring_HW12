package ru.gb.homework12.observer;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserUpdatedListener implements ApplicationListener<UserUpdatedEvent> {
    @Override
    public void onApplicationEvent(UserUpdatedEvent event) {
        System.out.println("New event: user " +
                event.getUser().getName() + " updated.");
        System.out.println("New user: " + event.getUser().toString());
    }
}
