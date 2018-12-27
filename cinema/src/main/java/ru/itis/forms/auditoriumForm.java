package ru.itis.forms;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class auditoriumForm {
    public Long id;
    public String name;
    public Integer numberOfSeats;
}
