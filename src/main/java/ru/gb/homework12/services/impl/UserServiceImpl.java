package ru.gb.homework12.services.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.gb.homework12.logger.Logger;
import ru.gb.homework12.model.User;
import ru.gb.homework12.observer.UserUpdatedEvent;
import ru.gb.homework12.repository.UserRepository;
import ru.gb.homework12.services.UserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ApplicationEventPublisher publisher;

    private final Logger logger;

    @Override
    public List<User> getAllUsers() {
        logger.log("Users list received.");
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        logger.log("User found by id.");
        return userRepository.findById(id).orElseThrow(null);
    }

    @Override
    public User createUser(User user) {
        logger.log("User added.");
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if (userOptional.isPresent()){
            User userUpdate = userOptional.get();
            userUpdate.setName(user.getName());
            userUpdate.setAge(user.getAge());
            userUpdate.setEmail(user.getEmail());
            logger.log("User updated.");
            publisher.publishEvent(new UserUpdatedEvent(this, userUpdate));
            return userRepository.save(userUpdate);
        } else{
            throw new IllegalArgumentException("User with id " + user.getId() + " not found!");
        }
    }

    @Override
    public void deleteUser(Long id) {
        logger.log("User deleted.");
        userRepository.deleteById(id);
    }
}
