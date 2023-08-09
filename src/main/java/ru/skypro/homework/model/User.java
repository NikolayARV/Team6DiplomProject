package ru.skypro.homework.model;

import lombok.Data;
import ru.skypro.homework.dto.Role;

import javax.persistence.*;

@Entity
@Data
@Table(name = "author")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String image;

}
