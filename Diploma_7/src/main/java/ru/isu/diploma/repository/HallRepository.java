package ru.isu.diploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.isu.diploma.model.Hall;

@Repository
public interface HallRepository extends JpaRepository<Hall, Integer> {
}
