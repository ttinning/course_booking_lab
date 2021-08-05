package com.codeclan.example.courseservice.controllers;

import com.codeclan.example.courseservice.models.Course;
import com.codeclan.example.courseservice.models.Customer;
import com.codeclan.example.courseservice.respositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getCourseByRating(
            @RequestParam(name = "rating", required = false) Integer starRating,
            @RequestParam(name = "customerId", required = false) Long customerId
    ) {
        if (starRating != null) {
            return new ResponseEntity<List<Course>>(courseRepository.findCoursesByStarRating(starRating), HttpStatus.OK);
        }
        if (customerId != null) {
            return new ResponseEntity<List<Course>>(courseRepository.findCoursesByBookingsCustomerId(customerId), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.I_AM_A_TEAPOT);
    }

}
