package ru.itis.services;

import ru.itis.forms.LoginForm;
import ru.itis.models.Admin;
import ru.itis.repositories.AdminRepository;
import ru.itis.servlets.RegistrationServlet;

import java.util.List;

public class RegistrationServiceImpl implements RegistrationService {
    private AdminRepository adminRepository;
    public RegistrationServiceImpl(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }
    @Override
    public void addUser(LoginForm loginForm) {
        Admin admin = Admin.builder()
                .username(loginForm.getUsername())
                .password(loginForm.getPassword())
                .build();
        adminRepository.save(admin);
    }

    @Override
    public Admin findByName(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public Admin find(Long id) {
        return adminRepository.findOne(id);
    }

    @Override
    public List<Admin> getAdmin() {
        return adminRepository.findAll();
    }
}
