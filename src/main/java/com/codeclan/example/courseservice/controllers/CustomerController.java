package com.codeclan.example.courseservice.controllers;

import com.codeclan.example.courseservice.models.Customer;
import com.codeclan.example.courseservice.respositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name = "course", required = false) Long courseId,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "town", required = false) String town
    ) {
        if (town != null && age != null && courseId != null) {
            return new ResponseEntity<List<Customer>>(customerRepository.findCustomersByTownIgnoreCaseAndAgeGreaterThanAndBookingsCourseId(town, age, courseId), HttpStatus.OK);
        }
        if (town != null && courseId != null) {
            return new ResponseEntity<List<Customer>>(customerRepository.findCustomersByTownAndBookingsCourseId(town, courseId), HttpStatus.OK);
        }
        if (courseId != null) {
            return new ResponseEntity<List<Customer>>(customerRepository.findCustomerByBookingsCourseId(courseId), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomerById(@PathVariable Long id) {
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }
}
