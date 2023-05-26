package com.jsp.controller;
import com.jsp.dao.studentDao;
public class SaveUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		studentDao student =new studentDao();
		String email="vishakha@22";
		boolean b=student.updateStudentById(6, email);
		System.out.println(b);

	}

}
