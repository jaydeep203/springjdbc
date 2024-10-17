package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao{
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		
		String query = "insert into student(id,name,city) values(?,?,?);";
		
		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		
		return r;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Student getStudent(int studentId) {
		String query = "SELECT * FROM student WHERE id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student r = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return r;
	}

	public List<Student> getAllStudents() {
		String query = "SELECT * FROM student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}
	
}
