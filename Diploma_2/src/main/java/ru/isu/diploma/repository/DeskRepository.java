package ru.isu.diploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.isu.diploma.model.Desk;
import ru.isu.diploma.model.Hall;

import java.util.List;

@Repository
public interface DeskRepository extends JpaRepository<Desk, Integer> {
    List<Desk> getDesksByHall(Hall hall);
}
