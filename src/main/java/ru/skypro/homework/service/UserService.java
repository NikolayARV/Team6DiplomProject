package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;

public interface UserService {
    void updatePassword(NewPasswordDto newPasswordDto);
    UserDto getUserInformation(String email);
    UserDto updateUser(UpdateUserDto updateUser);
    UserDto updateUserAvatar (String avatar);

}
