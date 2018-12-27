package ru.itis.repositories;

import ru.itis.models.User;

public interface UserRepository extends CrudRepository<User> {
    User findByName(String name);
}
