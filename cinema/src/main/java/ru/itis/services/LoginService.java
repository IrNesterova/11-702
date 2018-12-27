package ru.itis.services;

import ru.itis.forms.LoginForm;
import ru.itis.models.Admin;
import ru.itis.models.Employee;

import java.util.Optional;

public interface LoginService {
    Optional<String> login(LoginForm loginForm);
    boolean isExistByCookie(String cookieValue);
    Admin getUserByCookie(String cookieValue);
}
