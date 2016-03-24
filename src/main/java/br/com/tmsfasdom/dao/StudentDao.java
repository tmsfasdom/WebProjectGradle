package br.com.tmsfasdom.dao;

import java.util.List;

import br.com.tmsfasdom.modelo.Student;

public interface StudentDao {
	public void saveOrUpdate(Student student);
	public void delete(int studentId);
	public Student getStudent(int studentId);
	@SuppressWarnings("rawtypes")
	public List getAllStudent();
}
