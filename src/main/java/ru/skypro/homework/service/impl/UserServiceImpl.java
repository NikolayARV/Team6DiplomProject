package ru.skypro.homework.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.ImageService;
import ru.skypro.homework.service.UserService;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final ImageService imageService;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder encoder, ImageService imageService) {
        this.userRepository = userRepository;
        this.encoder = encoder;

        this.imageService = imageService;
    }


    @Override
    public void updatePassword(String username, NewPasswordDto newPasswordDto) {

        UserDto userDto = UserDto.fromUser(userRepository.findUserByUsername(username).orElseThrow(NoSuchElementException::new));

        String encryptedPassword = userDto.getPassword();
        if (encoder.matches(newPasswordDto.getCurrentPassword(), encryptedPassword)) {
            userDto.setPassword(encoder.encode(newPasswordDto.getNewPassword()));

            userRepository.save(userDto.toUser());
        } else {
            throw new NoSuchElementException("User inputs wrong current password");
        }

    }

    @Override
    public UserDto getUserInformation(String email) {

        return UserDto.fromUser(userRepository.findUserByUsername(email).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public UserDto updateUser(String email, UpdateUserDto updateUser) {
        User user = userRepository.getUserByUsername(email);
        user.setFirstName(updateUser.getFirstName());
        user.setLastName(updateUser.getLastName());
        user.setPhone(updateUser.getPhone());
        userRepository.save(user);
        return UserDto.fromUser(user);

    }

    @Override
    public void updateUserAvatar(String username, MultipartFile image) {
        String avatar = imageService.uploadImage(image);
        UserDto userDto = UserDto.fromUser(userRepository
                .findUserByUsername(username)
                .orElseThrow(NoSuchElementException::new));
        userDto.setImage(avatar);
        userRepository.save(userDto.toUser());


    }

    @Override
    public byte[] getAvatar(String username) {
        UserDto userDto = UserDto.fromUser(userRepository
                .findUserByUsername(username)
                .orElseThrow(NoSuchElementException::new));
        return imageService.getImage(userDto.getImage());
    }

    @Override
    public User getUser(String username) {
        return userRepository.getUserByUsername(username);
    }
}
