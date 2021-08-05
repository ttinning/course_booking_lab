package com.codeclan.example.courseservice.respositories;

import com.codeclan.example.courseservice.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
