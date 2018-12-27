package ru.itis.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.itis.forms.LoginForm;
import ru.itis.models.Admin;
import ru.itis.models.Auth;
import ru.itis.models.Employee;
import ru.itis.repositories.AdminRepository;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.EmployeeRepository;

import java.util.Optional;
import java.util.UUID;

public class LoginServiceImpl implements LoginService {
    private AdminRepository adminRepository;
    private BCryptPasswordEncoder encoder;
    private AuthRepository authRepository;
    public LoginServiceImpl(AdminRepository adminRepository, AuthRepository authRepository){
        this.adminRepository = adminRepository;
        this.encoder = new BCryptPasswordEncoder();
        this.authRepository = authRepository;
    }


    @Override
    public Optional<String> login(LoginForm loginForm) {

        Admin admin = adminRepository.findByUsername(loginForm.getUsername());
        if (admin !=null && encoder.matches(loginForm.getPassword(), admin.getPassword())){
            String cookieValue = UUID.randomUUID().toString();
            Auth auth = Auth.builder()
                    .cookieValue(cookieValue)
                    .admin(admin)
                    .build();
            authRepository.save(auth);
            return Optional.of(cookieValue);
        } else return Optional.empty();
    }

    @Override
    public boolean isExistByCookie(String cookieValue) {
        return authRepository.findByCookieValue(cookieValue).isPresent();
    }

    @Override
    public Admin getUserByCookie(String cookieValue) {
        Auth auth = authRepository.findByCookieValue(cookieValue).get();
        return Admin.builder()
                .id(adminRepository.findOne(auth.getAdmin().getId()).getId())
                .username(adminRepository.findOne(auth.getAdmin().getId()).getUsername())
                .password((adminRepository.findOne(auth.getAdmin().getId())).getPassword())
                .build();
    }

}
