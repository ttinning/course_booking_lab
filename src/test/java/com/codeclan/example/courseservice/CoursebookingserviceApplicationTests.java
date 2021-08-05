package com.codeclan.example.courseservice;

import com.codeclan.example.courseservice.models.Booking;
import com.codeclan.example.courseservice.models.Course;
import com.codeclan.example.courseservice.models.Customer;
import com.codeclan.example.courseservice.respositories.BookingRepository;
import com.codeclan.example.courseservice.respositories.CourseRepository;
import com.codeclan.example.courseservice.respositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CoursebookingserviceApplicationTests {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	BookingRepository bookingRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createCustomerCourseAndBooking() {
		Customer customer = new Customer("Aly", "Edinburgh", 31);
		customerRepository.save(customer);
		Course course = new Course("CodeClan", "Edinburgh", 5);
		courseRepository.save(course);
		Booking booking = new Booking("05/08/2021", customer, course);
		bookingRepository.save(booking);
		customer.addBooking(booking);
		assertEquals(1, customer.getBookings().size());
	}

}
