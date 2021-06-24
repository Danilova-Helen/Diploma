package ru.isu.diploma.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Desk {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Integer number; //номер стола

    @ManyToOne
    private Hall hall; //id зала

    private Integer quantity; //количество мест за столом

    private String grade; //значение для class

    private String position; //значение position для style

    private Double leftCord; //координаты left для style

    private Double topCord; //координаты top для style

    private String img; //путь к картинке стола
}