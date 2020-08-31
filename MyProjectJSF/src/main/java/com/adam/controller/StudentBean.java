package com.adam.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.adam.model.Student;
import com.adam.repo.StudentRepo;

@Named
@SessionScoped
public class StudentBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StudentRepo repo = new StudentRepo();

	public List<Student> getAllStudent() {
		return repo.getAllStudents();
	}

	public String create() {
		Student student = new Student();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("newStudent", student);
		return "/create.xhtml?faces-redirect=true";
	}

	public String save(Student student) {
		repo.save(student);
		return "/index.xhtml?faces-redirect=true";
	}

	public String edit(int id) {
		Student student = repo.findById(id);
		System.out.println(student);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("studentEdit", student);

		return "/edit.xhtml?faces-redirect=true";
	}

	public String update(Student student) {
		repo.edit(student);
		return "/index.xhtml?faces-redirect=true";
	}

	public String delete(int id) {
		repo.delete(id);
		return "/index.xhtml?faces-redirect=true";
	}

	public String moveToStudents() {
		return "/students.xhtml?faces-redirect=true";
	}

	public String moveToClasses() {
		return "/classes.xhtml?faces-redirect=true";
	}
}
