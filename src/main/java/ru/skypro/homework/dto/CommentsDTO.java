package ru.skypro.homework.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@Data
public class CommentsDTO {
    private Integer count; //($int32) общее кол-во комментариев
    private List<CommentDTO> results;
}
