package ru.itis.forms;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationForm {
    private String first_name;
    private String last_name;
    private String login;
    private String email;
    private String password;
    private String secretQuestion;
    private String secretAnswer;

}
