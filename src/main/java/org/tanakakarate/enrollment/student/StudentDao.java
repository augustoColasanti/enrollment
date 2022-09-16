package org.tanakakarate.enrollment.student;

import java.util.List;

public interface StudentDao {

	List<Student> getStudents(String sort);

	int addStudent(Student student);

}
