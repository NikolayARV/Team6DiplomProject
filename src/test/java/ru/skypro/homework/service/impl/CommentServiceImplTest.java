package ru.skypro.homework.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.repository.UserRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {
    @Mock
    private AdRepository adRepository;
    @Mock
    private CommentRepository commentRepository;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CommentServiceImpl out;
    User user = new User(1, "Bob", "Mjn", "name", "password", "2332343212", "USER", true, "gdhfhfhdh");
    Ad ad = new Ad();

    Comment comment = new Comment(user, ad, user.getImage(),
            "Bob", Instant.now(), "Коммент");
    List<Comment> list = new ArrayList<>();



    @Test
    void getAllCommentsForAdById() {
        list.add(comment);
        when(commentRepository.findCommentsByAd_Pk(ad.getPk())).thenReturn(Optional.of(list));
        List<CommentDto> commDto = new CommentsDto().fromCommentsList(list);
        assertEquals(out.getAllCommentsForAdById(ad.getPk()).getResults(), commDto);
    }

    @Test
    void createNewComment() {

    }

    @Test
    void deleteComment() {

    }

    @Test
    void updateComment() {
    }

    @Test
    void getCurrentTimeStamp() {
    }
}