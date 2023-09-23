package ru.skypro.homework.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.model.User;
import ru.skypro.homework.service.ImageService;
import ru.skypro.homework.service.UserService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Mock
    private UserService userService;
    @Mock
    private ImageService imageService;


    @InjectMocks
    private UserController out;
    User user = new User(1, "Bob",
            "Mjn", "name",
            "password", "2332343212",
            "USER", true,"gdhfhfhdh");

    @Test
    void setPassword() {

    }

    @Test
    void getUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void image() {
    }

    @Test
    void getImage() {
    }
}