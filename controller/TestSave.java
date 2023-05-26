package com.jsp.controller;

import com.jsp.dao.studentDao;
import com.jsp.dto.Student;

public class TestSave {

	public static void main(String[] args) {
		Student student = new Student();
		student.setId(8);
		student.setName("vishakha");
		student.setEmail("xyz@gmail.com");
		student.setPno(97736366);
		studentDao studentDao = new studentDao();
		Student s = studentDao.saveStudent(student);
		System.out.print(s.getName() + " Save Sucessfully");
	}

}
