package com.codeclan.example.courseservice.respositories;

import com.codeclan.example.courseservice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
