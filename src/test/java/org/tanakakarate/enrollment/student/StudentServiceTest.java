package org.tanakakarate.enrollment.student;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentServiceTest {
	
	@Autowired
	StudentService studentService;
	
	@Test
	void shouldGetStudentsByAscOrder() {
		List<Student> students = studentService.getStudents("ASC");
		assertTrue(students.size() > 0); // database pre-seeded
		
		boolean isAscOrder = true;
		for (int i = 0; i < students.size() - 1; i++) {
			LocalDate olderDate = students.get(i).startDate();
			LocalDate earlierDate = students.get(i + 1).startDate();
			isAscOrder = isAscOrder && (olderDate.isBefore(earlierDate) 
					|| olderDate.isEqual(earlierDate));
		}
		assertTrue(isAscOrder == true);
	}
	
	@Test
	void shouldAddStudent() {
		Student student = new Student("Augusto", LocalDate.now());
		int result = studentService.addStudent(student);
		assertTrue(result == 1);
	}
	
	@Test
	void shouldFailAddStudent() {
		Student student = new Student();
		assertThrows(Exception.class, () -> {
			studentService.addStudent(student);
	    });
	}
}
