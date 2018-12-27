package ru.itis.services;

import ru.itis.forms.LoginForm;
import ru.itis.models.Admin;

import java.util.List;

public interface RegistrationService {
    void addUser(LoginForm loginForm);
    Admin findByName(String username);
    Admin find(Long id);
    List<Admin> getAdmin();
}
