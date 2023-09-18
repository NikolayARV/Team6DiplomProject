package ru.skypro.homework.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk; //id объявления
    @ManyToOne
    private User user; //id автора объявления(имя)
    private String image;//ссылка на картинку объявления
    private Integer price;//цена объявления
    private String title;//заголовок объявления
    private String description;// описание


}
