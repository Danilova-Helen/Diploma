package ru.isu.diploma.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Time {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String time;
}