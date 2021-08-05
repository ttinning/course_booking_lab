package com.codeclan.example.courseservice.respositories;

import com.codeclan.example.courseservice.models.Course;
import com.codeclan.example.courseservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findCoursesByStarRating(Integer starRating);
    List<Course> findCoursesByBookingsCustomerId(Long customerId);
}
