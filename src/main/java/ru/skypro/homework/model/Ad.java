package ru.skypro.homework.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk;
    @ManyToOne
    //id автора объявления
    private User user;

    //ссылка на картинку объявления
    private String image;
    //цена объявления
    private Integer price;
    //заголовок объявления
    private String title;


}
