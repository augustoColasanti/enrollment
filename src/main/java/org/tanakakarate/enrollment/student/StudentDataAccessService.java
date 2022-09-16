package org.tanakakarate.enrollment.student;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDataAccessService implements StudentDao {

	private final JdbcTemplate jdbcTemplate;

	public StudentDataAccessService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Student> getStudents(String sort) {
		StringBuilder sql = new StringBuilder(
				"SELECT id, name, start_date FROM student ORDER BY start_date ")
				.append(sort);

		return jdbcTemplate.query(sql.toString(), new StudentRowMapper());
	}

	@Override
	public int addStudent(Student student) {
		String sql = "INSERT INTO student(name, start_date) VALUES (?, ?)";
		return jdbcTemplate.update(sql, student.name(), student.startDate());
	}

}
