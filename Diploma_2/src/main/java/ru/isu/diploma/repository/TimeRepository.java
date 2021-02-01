package ru.isu.diploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.isu.diploma.model.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {
}
