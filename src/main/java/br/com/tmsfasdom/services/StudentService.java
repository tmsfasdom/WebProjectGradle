package br.com.tmsfasdom.services;

import java.util.List;
import br.com.tmsfasdom.modelo.Student;

public interface StudentService {

	public void save(Student student);
	public void update(Student student);
	public void delete(int studentId);
	public Student getStudent(int studentId);
	public List<Student> getAllStudent();
}

