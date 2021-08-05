package com.codeclan.example.courseservice.respositories;

import com.codeclan.example.courseservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomerByBookingsCourseId(Long courseId);
    List<Customer> findCustomersByTownAndBookingsCourseId(String town, Long courseId);
    List<Customer> findCustomersByTownIgnoreCaseAndAgeGreaterThanAndBookingsCourseId(String town, Integer age, Long courseId);
}
