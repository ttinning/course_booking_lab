package com.codeclan.example.courseservice.controllers;

import com.codeclan.example.courseservice.models.Booking;
import com.codeclan.example.courseservice.models.Customer;
import com.codeclan.example.courseservice.respositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(
            @RequestParam(name = "date", required = false) String date
    ) {
        return new ResponseEntity<List<Booking>>(bookingRepository.findBookingsByDate(date), HttpStatus.OK);
    }

}
