package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.Inet4Address;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatForm {
    private Integer row;
    private Integer number;
}
