package ru.isu.diploma.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Desk {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Integer number;

    @ManyToOne
    private Hall hall;

    private Integer quantity;

    private String position;

    private Double leftCord;

    private Double topCord;
}
