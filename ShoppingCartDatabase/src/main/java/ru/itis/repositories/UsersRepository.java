package ru.itis.repositories;

import ru.itis.models.User;

import java.util.Optional;
import javax.swing.text.html.Option;

public interface UsersRepository extends CrudRepository<User ,Long> {
    Optional<User> findByPhone(String phone);
}