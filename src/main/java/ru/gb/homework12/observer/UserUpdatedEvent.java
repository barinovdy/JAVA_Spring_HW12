package ru.gb.homework12.observer;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.gb.homework12.model.User;

@Getter
public class UserUpdatedEvent extends ApplicationEvent {
    private final User user;

    public UserUpdatedEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
