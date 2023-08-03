package ru.skypro.homework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
@Data
public class CreateOrUpdateCommentDTO {
    private String text; //minLength: 8, maxLength: 64 текст комментария
}
