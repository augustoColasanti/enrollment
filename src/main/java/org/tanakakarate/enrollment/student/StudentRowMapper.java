package org.tanakakarate.enrollment.student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Student(
				rs.getInt("id"), 
				rs.getString("name"), 
				LocalDate.parse(rs.getString("start_date")));
	}

}
