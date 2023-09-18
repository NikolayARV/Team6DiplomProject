package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.model.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findByPk(Integer pk);
    List<Comment> findAllByAd_Pk(Integer pk);

}
