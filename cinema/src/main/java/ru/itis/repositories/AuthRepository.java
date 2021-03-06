package ru.itis.repositories;

import ru.itis.models.Admin;
import ru.itis.models.Auth;

import java.util.Optional;

public interface AuthRepository extends CrudRepository<Auth> {
    Optional<Auth> findByCookieValue(String cookieValue);
    public void deleteCookieByUserId(Admin admin);
}
