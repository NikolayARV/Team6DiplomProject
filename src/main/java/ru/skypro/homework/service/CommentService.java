package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.model.Comment;

public interface CommentService {
    CommentsDto getAllCommentsForAdById(Integer adPk);
    CommentDto createNewComment(Integer adPk, CreateOrUpdateCommentDto createOrUpdateCommentDto, String username);
    //CommentDto getComment (Integer adPk, Integer commentId);
    void deleteComment (Integer adPk, Integer commentPk);
    CommentDto updateComment (Integer adPk, Integer commentId, CreateOrUpdateCommentDto createOrUpdateCommentDto);
    //Comment getCommentById (Integer commentId);
}
