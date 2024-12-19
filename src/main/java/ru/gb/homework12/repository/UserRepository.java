package ru.gb.homework12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.homework12.model.User;

public interface UserRepository extends JpaRepository<User, Long>  {
}
