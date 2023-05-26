package com.jsp.controller;
import com.jsp.dto.Student;
import java.util.ArrayList;
import com.jsp.dao.studentDao;
public class MultipleStudentDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Student s1=new Student();
ArrayList <Student> a1=new ArrayList<>();
s1.setId(13);
s1.setName("rahul");
s1.setEmail("rahul@344");
s1.setPno(525356767);

Student s2=new Student();
s2.setId(14);
s2.setName("priya");
s2.setEmail("priya@344");
s1.setPno(2795799);

Student s3=new Student();
s3.setId(15);
s3.setName("rani");
s3.setEmail("rani@344");
s3.setPno(567889999);

Student s4=new Student();
s4.setId(16);
s4.setName("rani");
s4.setEmail("rani@344");
s4.setPno(567889999);
a1.add(s4);
a1.add(s1);
a1.add(s2);
a1.add(s3);

studentDao student =new studentDao();
 student.addMultipleStudents(a1);




	}

}
