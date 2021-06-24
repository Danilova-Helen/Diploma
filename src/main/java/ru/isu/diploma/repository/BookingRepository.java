package ru.isu.diploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.isu.diploma.model.Booking;
import ru.isu.diploma.model.Time;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findBookingsByBeginTime_IdLessThanAndEndTime_IdGreaterThan(Integer beginTime, Integer endTime);
    List<Booking> findBookingsByBeginTimeEqualsAndEndTimeEquals(Time beginTime, Time endTime);
}
