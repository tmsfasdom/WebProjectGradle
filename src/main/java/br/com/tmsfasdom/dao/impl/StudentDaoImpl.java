package br.com.tmsfasdom.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.tmsfasdom.dao.StudentDao;
import br.com.tmsfasdom.modelo.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	private SessionFactory session;

	public StudentDaoImpl() {

	}

	@Autowired
	public StudentDaoImpl(SessionFactory sessionFactory) {
		this.session = sessionFactory;
	}

	@Override
	public void saveOrUpdate(Student student) {
		session.getCurrentSession().saveOrUpdate(student);
	}

	@Override
	public void delete(int studentId) {
		session.getCurrentSession().delete(getStudent(studentId));
	}

	@Override
	public Student getStudent(int studentId) {
		return (Student) session.getCurrentSession().get(Student.class, studentId);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getAllStudent() {
		return session.getCurrentSession().createQuery("from Student").list();
	}

}
