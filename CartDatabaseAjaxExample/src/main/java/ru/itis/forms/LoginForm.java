package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.DocFlavor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {
    private String name;
    private String password;
}
