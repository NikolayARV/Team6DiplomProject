package ru.skypro.homework.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void updatePassword(String email, NewPasswordDto newPasswordDto) {
       /** Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserDto.fromUser(userRepository.findByUsername(username));
        */
    }

    @Override
    public UserDto getUserInformation(String email) {
        return null;
    }

    @Override
    public UserDto updateUser(String email, UpdateUserDto updateUser) {
        return null;
    }

    @Override
    public UserDto updateUserAvatar(String email, MultipartFile file) {
        return null;
    }
}
