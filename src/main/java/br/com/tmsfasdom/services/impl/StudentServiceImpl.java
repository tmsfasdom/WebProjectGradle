package br.com.tmsfasdom.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tmsfasdom.dao.StudentDao;
import br.com.tmsfasdom.modelo.Student;
import br.com.tmsfasdom.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDaoo;
	
	@Transactional
	public void saveOrUpdate(Student student) {
		studentDaoo.saveOrUpdate(student);
	}
	
	@Transactional
	public void delete(int studentId) {
		studentDaoo.delete(studentId);
	}

	@Transactional
	public Student getStudent(int studentId) {
		return studentDaoo.getStudent(studentId);
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List getAllStudent() {
		return studentDaoo.getAllStudent();
	}

}

	
