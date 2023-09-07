package ru.skypro.homework.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
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
    public void updatePassword(NewPasswordDto newPasswordDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserDto oldPasswordUserDto = new UserDto().fromUser(userRepository.findByUserName(username));
        if ((newPasswordDto.getCurrentPassword()).equals(oldPasswordUserDto.getPassword())){
            oldPasswordUserDto.setPassword(newPasswordDto.getNewPassword());
            userRepository.findByUserName(username).setPassword(oldPasswordUserDto.getPassword());
        }
// Прописать длинну пароля
    }

    @Override
    public UserDto getUserInformation(String email) {
        return new UserDto().fromUser(userRepository.findByUserName(email));
    }

    @Override
    public UserDto updateUser(UpdateUserDto updateUser) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserDto oldUserDto = new UserDto().fromUser(userRepository.findByUserName(username));
        oldUserDto.setFirstName(updateUser.getFirstName());
        oldUserDto.setLastName(updateUser.getLastName());
        oldUserDto.setPhone(updateUser.getPhone());
        User updatedUser = oldUserDto.toUser();
        userRepository.save(updatedUser);
        return oldUserDto;
        //прописать параметры вводимых данных
    }

    @Override
    public UserDto updateUserAvatar(String avatar) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        (userRepository.findByUserName(authentication.getName())).setImage(avatar);
        User newAvatarUser = userRepository.findByUserName(authentication.getName());
        return new UserDto().fromUser(newAvatarUser);
    }
}
