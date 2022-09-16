package org.tanakakarate.enrollment.student;

import java.time.LocalDate;

public record Student(Integer id, String name, LocalDate startDate) {

	public Student(String name, LocalDate startDate) {
		this(null, name, startDate);
	}
	
	public Student() {
		this(null, null, null);
	}

}
