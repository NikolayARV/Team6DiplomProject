package ru.skypro.homework.model;

import javax.persistence.*;


@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk;

    @ManyToOne
    //id автора комментария
    private User author;

    //ссылка на аватар автора комментария
    private String authorImage;
    //имя создателя комментария
    private String authorFirstName;
    //дата и время создания комментария в миллисекундах с 00:00:00 01.01.1970
    private Integer createdAt;
    //текст комментария
    private String text;
}
