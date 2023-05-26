package com.jsp.controller;
import com.jsp.dao.studentDao;
import com.jsp.dto.Student;
public class StudentDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
studentDao student =new studentDao();
    Student s=student.getStudentById(3);
    System.out.println(s.getId());
	}

}
