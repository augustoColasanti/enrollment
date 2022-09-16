package org.tanakakarate.enrollment.student;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final StudentDao studentDao;

	public StudentService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public List<Student> getStudents(String sort) {
		return studentDao.getStudents(sort);
	}

	public int addStudent(Student student) {
		int response = studentDao.addStudent(student);
		if (response != 1) {
			throw new IllegalStateException("Student could not be saved.");
		}
		return response;
	}

}
