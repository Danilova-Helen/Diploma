package ru.isu.diploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.isu.diploma.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
