package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.model.Comment;

public interface CommentService {
    CommentsDto getAllCommentsForAdById(Integer adPk);
    CommentsDto createNewComment(Integer adPk, CreateOrUpdateCommentDto createOrUpdateCommentDto);
    //CommentDto getComment (Integer adPk, Integer commentId);
    void deleteComment (Integer adPk, Integer commentPk);
    CommentDto updateComment (Integer adPk, Integer commentId, CreateOrUpdateCommentDto createOrUpdateCommentDto);
    //Comment getCommentById (Integer commentId);
}
