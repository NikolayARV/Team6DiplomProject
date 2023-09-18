package ru.skypro.homework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class UpdateUserDto {
    private String firstName; // minLength: 3, maxLength: 10 имя пользователя
    private String lastName; // minLength: 3, maxLength: 10 фамилия п-ля
    private String phone; // pattern: \+7\s?\(?\d{3}\)?\s?\d{3}-?\d{2}-?\d{2} телефон п-ля
}
