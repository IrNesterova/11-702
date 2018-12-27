package ru.itis.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.forms.RegistrationForm;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

public class UsersServiceImpl implements UsersService {
    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;
    public UsersServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    @Override
    public void signUp(RegistrationForm registrationForm) {
        User newUser = User.builder()
                .first_name(registrationForm.getFirst_name())
                .last_name(registrationForm.getLast_name())
                .login(registrationForm.getLogin())
                .email(registrationForm.getEmail())
                .password(passwordEncoder.encode(registrationForm.getPassword()))
                .secretQuestion(registrationForm.getSecretQuestion())
                .secretAnswer(passwordEncoder.encode(registrationForm.getSecretAnswer()))
                .build();
        usersRepository.save(newUser);
    }
}
