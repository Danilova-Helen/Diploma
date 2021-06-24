package ru.isu.diploma.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Hall {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String img; //путь к картинке зала

    private String grade; //значение для class
}