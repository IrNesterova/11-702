package ru.itis.models;

import lombok.Builder;
import lombok.Data;

import java.net.URL;

@Data
@Builder
public class User {
    public Long id;
    public URL avatar;
    public String first_name;
    public String last_name;
    public String login;
    public String password;
    public String email;
    public String secretQuestion;
    public String secretAnswer;
}
