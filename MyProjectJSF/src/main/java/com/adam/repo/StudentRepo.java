package com.adam.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.adam.model.Student;
import com.adam.utils.JPAUtil;

public class StudentRepo {

	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

	public void save(Student student) {
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
//		JPAUtil.shutdown();
	}

	public void edit(Student student) {
		entityManager.getTransaction().begin();
		entityManager.merge(student);
		entityManager.getTransaction().commit();
		// JPAUtil.shutdown();
	}

	public Student findById(int id) {
		Student student = new Student();
		student = entityManager.find(Student.class, id);
//		JPAUtil.shutdown();
		return student;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<Student>();
		Query query = entityManager.createQuery("SELECT s FROM Student s");
		list = query.getResultList();
		return list;
	}

	public void delete(int id) {
		Student student = new Student();
		student = entityManager.find(Student.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(student);
		entityManager.getTransaction().commit();
	}

}
