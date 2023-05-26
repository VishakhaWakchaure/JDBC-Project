package com.jsp.controller;

import java.util.List;
import com.jsp.dao.studentDao;
import com.jsp.dto.Student;

public class GetAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
studentDao student =new studentDao();
List<Student> a1=student.getAllstudent();

for(Student s:a1) {
 System.out.println(s.getId());
 System.out.println(s.getName());
 System.out.println(s.getPno());
 System.out.println(s.getEmail());
 System.out.println(" =========================");
}
	}

}
