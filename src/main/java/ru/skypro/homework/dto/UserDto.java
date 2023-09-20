package ru.skypro.homework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.AuthoritiesRepository;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class UserDto {
    private Integer id; // ($int32)
    private String email; //логин пользователя
    private String firstName; //имя пользователя
    private String lastName; //фамилия пользователя
    private String phone; //телефон пользователя
    private String role; //роль пользователя
    private String image; // ссылка на аватар пользователя
   // private String password;
    //private boolean enabled;


    public static UserDto fromUser(User user) {

        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setEmail(user.getUsername());
        //dto.setPassword(user.getPassword());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole());
        if (user.getImage() != null) {
            dto.setImage(String.format("/users/image/%s", user.getImage()));
        } else {
            dto.setImage(null);
        }
        //dto.setEnabled(user.isEnabled());
        return dto;
    }


    public User toUser() {
        User user = new User();
        user.setId(this.getId());
        user.setUsername(this.getEmail());
        //user.setPassword(this.getPassword());
        user.setFirstName(this.getFirstName());
        user.setLastName(this.getLastName());
        user.setPhone(this.getPhone());
        if (this.getRole() == null) {
            user.setRole(Role.USER.name());
        } else {
            user.setRole(this.getRole());
        }

        user.setImage(this.getImage());
        //user.setEnabled(this.isEnabled());
        return user;
    }
}
