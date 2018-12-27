package ru.itis.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.itis.forms.LoginForm;
import ru.itis.forms.UserForm;
import ru.itis.models.Auth;
import ru.itis.models.User;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.UserRepository;

import java.util.Optional;
import java.util.UUID;

public class LoginServiceImpl implements LoginService {
    private AuthRepository authRepository;

    private UserRepository usersRepository;

    private BCryptPasswordEncoder encoder;

    public LoginServiceImpl(AuthRepository authRepository, UserRepository usersRepository) {
        this.authRepository = authRepository;
        this.usersRepository = usersRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public Optional<String> login(LoginForm loginForm) {
        User user = usersRepository.findByName(loginForm.getName());
        if (user != null && encoder.matches(loginForm.getPassword(), user.getPasswordHash())) {
            String cookieValue = UUID.randomUUID().toString();
            Auth auth = Auth.builder()
                    .cookieValue(cookieValue)
                    .user(user)
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
    public User getUserByCookie(String cookieValue) {
        Auth auth = authRepository.findByCookieValue(cookieValue).get();
        return User.builder()
                .id(usersRepository.find(auth.getUser().getId()).getId())
                .name(usersRepository.find(auth.getUser().getId()).getName())
                .passwordHash((usersRepository.find(auth.getUser().getId())).getPasswordHash())
                .build();
    }
}
