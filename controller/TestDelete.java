package com.jsp.controller;

import com.jsp.dao.studentDao;

public class TestDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		studentDao  student = new studentDao ();
	System.out.println(student.deleteStudentById(4));
	}

}
