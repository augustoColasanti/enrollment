package org.tanakakarate.enrollment.student;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	StudentController studentController;

	@Mock
	StudentService studentService;

	@BeforeEach
	public void before() {
		mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
	}

	@Test
	void shouldCallGetStudents() throws Exception {
		mockMvc.perform(get("/api/students?sort=ASC").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void shouldCallAddStudents() throws Exception {
		String studentJson = new JSONObject()
								.put("name", "Augusto")
								.put("startDate", LocalDate.now())
								.toString();
		
		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/students")
				.contentType(MediaType.APPLICATION_JSON)
				.content(studentJson))
				.andExpect(status().isOk());
	}
	
	@Test
	void shouldFailAddStudents() throws Exception {		
		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/students")
				.contentType(MediaType.APPLICATION_JSON)
				.content(""))
				.andExpect(status().is4xxClientError());
	}
}
