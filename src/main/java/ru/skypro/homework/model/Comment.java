package ru.skypro.homework.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk;

    @ManyToOne
    //id автора комментария
    private User user;

    @ManyToOne
    //id объявления
    private Ad ad;
    //ссылка на аватар автора комментария
    private String userImage;
    //имя создателя комментария
    private String userFirstName;
    //дата и время создания комментария в миллисекундах с 00:00:00 01.01.1970
    private String createdAt; //Почему в openapi стоит Integer????
    //текст комментария
    private String text;

    public Comment(){};

    public Comment(User user, Ad ad, String userImage, String userFirstName, String createdAt, String text) {
        this.user = user;
        this.ad = ad;
        this.userImage = userImage;
        this.userFirstName = userFirstName;
        this.createdAt = createdAt;
        this.text = text;
    }
}
