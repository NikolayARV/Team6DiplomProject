package ru.skypro.homework.model;

import javax.persistence.*;

@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk;
    @ManyToOne
    //id автора объявления
    private User author;

    //ссылка на картинку объявления
    private String image;
    //цена объявления
    private Integer price;
    //заголовок объявления
    private String title;


}
