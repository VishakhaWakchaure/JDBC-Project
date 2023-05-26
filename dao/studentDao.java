package com.jsp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dto.Student;
import com.jsp.helper.Helper;

public class studentDao 
{
  Helper helperclass=new Helper();
  Connection connection=null;
  
  //multiple student add 
  public void addMultipleStudents(List<Student> students) {
	  connection=helperclass.getConnection();
	  String sql ="INSERT INTO student values(?,?,?,?)";
	  
	  try {
		  //create statement
		  PreparedStatement preparedStatement=connection.prepareStatement(sql);
		  // execute statement
		  for(Student s:students) {
			  preparedStatement.setInt(1, s.getId());
			  preparedStatement.setString(2, s.getName());
			  preparedStatement.setString(3, s.getEmail());
			  preparedStatement.setInt(4, s.getPno());
			  preparedStatement.addBatch();
			  }
		      preparedStatement.executeBatch();
		      System.out.println("All good");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  }
  
  
  
  //getdetils
  public Student getStudentById(int id) {
	  connection=helperclass.getConnection();
	  String sql="SELECT *From student WHERE Id=?";
	  Student student2 =new Student();
	  try {
		  PreparedStatement preparedStatement=	connection.prepareStatement(sql);
		  preparedStatement.setInt(1, id);
		  //execute statement
		  ResultSet resultset=preparedStatement.executeQuery();
		  while(resultset.next()) {
			  int id2=resultset.getInt(1);
			  String name=resultset.getString(2);
			  String email=resultset.getNString(3);
			  int pno=resultset.getInt(4);
			  student2.setId(id2);
			  student2.setEmail(email);
			  student2.setName(name);
			  student2.setPno(pno);
			  
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return student2;
  }
 
  
 //update
  public boolean updateStudentById(int id,String email) {
	  connection=helperclass.getConnection();
	  //create statement
	  String sql="UPDATE student set email=? WHERE Id=?";
	  
	  try {
		  PreparedStatement preparedStatement		=connection.prepareStatement(sql);
		  preparedStatement.setString(1,email); 
		  preparedStatement.setInt(2, id);
		  preparedStatement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return true;
  }
  
  
  
  
  
  //getAll
  
  public List<Student> getAllstudent(){
	  connection=helperclass.getConnection();
	  String sql="SELECT * From student";
	  ArrayList<Student> a1=null;
	  
	  PreparedStatement preparedStatement;
	  
	try {
		PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement1 .executeQuery();
	
		  a1=new ArrayList<>();
		  while(resultset.next()) {
			  int id=resultset.getInt(1);
			  String name=resultset.getString(2);
			  String email=resultset.getString(3);
			  int pno=resultset.getInt(4);
			  Student s=new Student();
			  s.setId(id);
			  s.setName(name);
			  s.setEmail(email);
			  s.setPno(pno);
			  a1.add(s);
			  
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return a1;
	  
	  
  }
  
  
  
  
  //delete 
  public boolean deleteStudentById(int id) {
	  connection=helperclass.getConnection();
	  String sql="DELETE From student WHERE id=?";
	  boolean res=false;
	  
  try {
	  PreparedStatement preparedStatement	=connection.prepareStatement(sql);
	  preparedStatement.setInt(1, id);
	  
	  //execute
//boolean res= preparedStatement.execute();
	
int res2=preparedStatement.executeUpdate();
if(res2>0) {
	res=true;
}else {
	res=false;
}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally {
	  try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return res;
  }
  }
  
  
  
  // to save student
  public  Student saveStudent(Student student)
  {
    Connection connection= helperclass.getConnection();
  
    
    String sql ="INSERT INTO student values(?,?,?,?)"; //delimiters/place holder
    
    //create statement
    PreparedStatement preparedStatement;
    try {
      preparedStatement = connection.prepareStatement(sql);
      
      preparedStatement.setInt(1,student.getId());
      preparedStatement.setString(2,student.getName());
      preparedStatement.setString(3,student.getEmail());
      preparedStatement.setInt(4,student.getPno());
      preparedStatement.execute();
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    finally {
      try {
        connection.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    
    //execute the statement 
    
    return student;
    
   
  }
}