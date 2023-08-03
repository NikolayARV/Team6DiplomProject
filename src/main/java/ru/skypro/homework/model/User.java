package ru.skypro.homework.model;

import ru.skypro.homework.dto.RoleDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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
