package ru.itis.services;

import ru.itis.forms.UserForm;
import ru.itis.models.User;
import ru.itis.repositories.UserRepository;

import java.util.List;

public class UsersServiceImpl implements UsersService{
    private UserRepository usersRepository;

    public UsersServiceImpl(UserRepository userRepository){
        this.usersRepository = userRepository;
    }


    @Override
    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    @Override
    public void addUser(UserForm userForm) {
        User newUser= User.builder()
                .name(userForm.getName())
                .build();
        usersRepository.save(newUser);
    }
}
