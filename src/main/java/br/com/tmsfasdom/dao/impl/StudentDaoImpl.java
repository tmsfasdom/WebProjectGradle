package br.com.tmsfasdom.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.tmsfasdom.dao.AbstractDao;
import br.com.tmsfasdom.modelo.Student;

@Repository
public class StudentDaoImpl extends AbstractDao<Student> {

	public StudentDaoImpl() {
		super(Student.class, Student.tableName);
	}
	
}
