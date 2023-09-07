package ru.skypro.homework.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.Register;
import ru.skypro.homework.dto.Role;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.model.Authorities;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.AuthoritiesRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserDetailsManager manager;
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    private final AuthoritiesRepository authoritiesRepository;

    public AuthServiceImpl(UserDetailsManager manager,
                           PasswordEncoder passwordEncoder, UserRepository userRepository, AuthoritiesRepository authoritiesRepository) {
        this.manager = manager;
        this.encoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authoritiesRepository = authoritiesRepository;
    }

    @Override
    public boolean login(String userName, String password) {
        if (!manager.userExists(userName)) {
            return false;
        }
        UserDetails userDetails = manager.loadUserByUsername(userName);
        return encoder.matches(password, userDetails.getPassword());
    }

    @Override
    public boolean register(Register register) {
        if (manager.userExists(register.getUsername())) {
            return false;
        }
        UserDto userDto =new UserDto();
        userDto.setUserName(register.getUsername());
        userDto.setPassword(encoder.encode(register.getPassword()));
        userDto.setRole(String.valueOf(Role.USER));
        userDto.setFirstName(register.getFirstName());
        userDto.setLastName(register.getLastName());
        userDto.setPhone(register.getPhone());
        User user = userDto.toUser();
        userRepository.save(user);
        authoritiesRepository.save(new Authorities(register.getUsername(),register.getRole(),user));

        return true;
    }

}
