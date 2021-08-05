package com.codeclan.example.courseservice.components;

import com.codeclan.example.courseservice.models.Booking;
import com.codeclan.example.courseservice.models.Course;
import com.codeclan.example.courseservice.models.Customer;
import com.codeclan.example.courseservice.respositories.BookingRepository;
import com.codeclan.example.courseservice.respositories.CourseRepository;
import com.codeclan.example.courseservice.respositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Customer zaki = new Customer("Zaki", "Edinburgh", 27);
        customerRepository.save(zaki);
        Customer tristan = new Customer("Tristan", "Edinburgh", 30);
        customerRepository.save(tristan);
        Customer gary = new Customer("Gary", "Aberdeen", 27);
        customerRepository.save(gary);

        Course codeclan = new Course("Software Development", "Edinburgh", 5);
        courseRepository.save(codeclan);
        Course university = new Course("Computer Science", "Glasgow", 3);
        courseRepository.save(university);
        Course college = new Course("Joinery", "Dundee", 2);
        courseRepository.save(college);

        Booking booking1 = new Booking("05/08/2021", tristan, college);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("16/05/2021", gary, codeclan);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking("21/05/2021", zaki, college);
        bookingRepository.save(booking3);
    }
}
