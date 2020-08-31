package com.adam.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ControllerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isShowFormSelect = true;
	private boolean isShowListStudent = false;
	private boolean isShowListClass = false;

	public void showStudents() {
//		isShowFormSelect = false;
		isShowListClass = false;

		isShowListStudent = true;
	}

	public void showClasses() {
//		isShowFormSelect = false;
		isShowListStudent = false;

		isShowListClass = true;
	}

	public void backToSelect() {
		isShowListStudent = false;
		isShowListClass = false;

//		isShowFormSelect = true;
	}

	public boolean isShowFormSelect() {
		return isShowFormSelect;
	}

	public void setShowFormSelect(boolean isShowFormSelect) {
		this.isShowFormSelect = isShowFormSelect;
	}

	public boolean isShowListStudent() {
		return isShowListStudent;
	}

	public void setShowListStudent(boolean isShowListStudent) {
		this.isShowListStudent = isShowListStudent;
	}

	public boolean isShowListClass() {
		return isShowListClass;
	}

	public void setShowListClass(boolean isShowListClass) {
		this.isShowListClass = isShowListClass;
	}

}
