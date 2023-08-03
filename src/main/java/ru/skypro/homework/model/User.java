package ru.skypro.homework.model;

import ru.skypro.homework.dto.RoleDTO;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String firstName;
    private String lastNAme;
    private String phone;
    private Role role;
    private String image;

}
