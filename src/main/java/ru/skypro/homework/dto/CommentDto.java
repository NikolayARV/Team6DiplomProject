package ru.skypro.homework.dto;

import lombok.*;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.UserRepository;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class CommentDto {
    private Integer user; // ($int32) id автороа комментария
    private String userImage; // ссылка на аватар автора комментария
    private String userFirstName; // имя создателя комментария
    private String createdAt; //($int32) дата и время создания комментария в миллисекундах с 00:00:00 01.01.1970
    private Integer pk; //($int32) id комментария
    private String text; // текст комментария
    UserRepository userRepository;


    public static CommentDto fromComment(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setPk(comment.getPk());
        dto.setUser(comment.getUser().getId());
        dto.setUserImage(comment.getUserImage());
        dto.setUserFirstName(comment.getUserFirstName());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setText(comment.getText());

        return dto;
    }


    public Comment toComment() {
        Comment comment = new Comment();
        comment.setPk(this.getPk());
        comment.setUser(userRepository.findById(this.getUser()).orElseThrow());
        comment.setUserImage(this.getUserImage());
        comment.setUserFirstName(this.getUserFirstName());
        comment.setCreatedAt(this.getCreatedAt());
        comment.setText(this.getText());


        return comment;
    }
}
