package ru.skypro.homework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Login {

    private String username; //minLength: 8, maxLength: 16
    private String password; //minLength: 4, maxLength: 32
}
