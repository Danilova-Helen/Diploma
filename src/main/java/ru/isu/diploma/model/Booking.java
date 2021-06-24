package ru.isu.diploma.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Desk desk; //номер стола

    private String fio; //ФИО бронирующего

    private String tel; //телефон бронирующего

    private Integer quantity; //кол-во гостей

    @ManyToOne
    private Time beginTime; //начало брони

    @ManyToOne
    private Time endTime; //конец брони

    private String com; //комментарий бронирующего
}