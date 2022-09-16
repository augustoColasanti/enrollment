package org.tanakakarate.enrollment.student;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public List<Student> getStudents(@RequestParam String sort) {
		return studentService.getStudents(sort);
	}

	@PostMapping
	public String addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		return "Success";
	}

}
