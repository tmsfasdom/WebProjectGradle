package br.com.tmsfasdom.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tmsfasdom.dao.AbstractDao;
import br.com.tmsfasdom.dao.impl.StudentDaoImpl;
import br.com.tmsfasdom.modelo.Student;
import br.com.tmsfasdom.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private AbstractDao<Student> studentDao;
	
	@Autowired
	public StudentServiceImpl(StudentDaoImpl studentDao) {
		this.studentDao = studentDao;
	}

	@Transactional
	public void save(Student student) {
		studentDao.save(student);
	}
	
	@Transactional
	public void delete(int studentId) {
		studentDao.delete(studentId);
	}

	@Transactional
	public Student getStudent(int studentId) {
		return studentDao.getEntity(studentId);
	}

	@Transactional
	public List<Student> getAllStudent() {
		return studentDao.getAll();
	}

	@Override
	public void update(Student student) {
		studentDao.update(student);
		
	}

}

	
