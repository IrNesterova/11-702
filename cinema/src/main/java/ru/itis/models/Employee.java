package ru.itis.models;

import lombok.*;

import java.net.URL;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Employee {
    private Long id;

    private String username;
    private String hashPassword;

    private String first_name;
    private String last_name;

    private String sex;
    private String photo;
}
