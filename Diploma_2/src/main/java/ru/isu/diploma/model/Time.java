package ru.isu.diploma.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Time {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private LocalDateTime time;
}
