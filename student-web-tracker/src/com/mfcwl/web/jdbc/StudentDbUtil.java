package com.mfcwl.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



public class StudentDbUtil {
	
	private DataSource dataSource;
	
	public StudentDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Student> getStudents() throws Exception {
	
		List<Student> students = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "select * from student order by id";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next()) {
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				//create new student object
				Student newStudent = new Student(id, firstName, lastName, email);
				
				students.add(newStudent);
			}
						
			return students;
		}
		finally {
			
			// close JDBC objects
			close(myConn, myStmt, myRs);
			
		}
				
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		
		try {
			if(myRs != null) myRs.close();
			if(myStmt != null) myStmt.close();
			if(myConn != null) myConn.close();
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}

	public void addStudent(Student newStudent) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			
			myConn = dataSource.getConnection();
			String sql = "insert into student " + "(first_name, last_name, email) " + 
						"values (?, ?, ?)";
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, newStudent.getFirstName());
			myStmt.setString(2, newStudent.getLastName());
			myStmt.setString(3, newStudent.getEmail());
			
			myStmt.execute();
			
		}
		finally {
			close(myConn, myStmt, null);
		}
		
	}

	public Student getStudent(String theStudentId) throws Exception {
		
		Student existingStudent = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int studentId;
		
		try {
			studentId = Integer.parseInt(theStudentId);
			System.out.println(studentId + "in getStudent");
			myConn = dataSource.getConnection();
			String sql = "select * from student where id=?";
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, studentId);
			myRs = myStmt.executeQuery();
			
			if(myRs.next()) {
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				existingStudent = new Student(studentId, firstName, lastName, email);
				return existingStudent;
				
			}else {
				throw new Exception("Could not find student id: " + studentId);
			}
			
		}
		
		finally {
			close(myConn, myStmt, myRs);
		}	
		
	}

	public void updateStudent(Student newStudent) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "update student " + 
						"set first_name=?, last_name=?, email=? " + 
						"where id=?";
			
		
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, newStudent.getFirstName());
			myStmt.setString(2, newStudent.getLastName());
			myStmt.setString(3, newStudent.getEmail());
			myStmt.setInt(4, newStudent.getId());
			
			System.out.println(myStmt);
			
			
			myStmt.execute();
			
			
			
		}
		finally {
			close(myConn, myStmt, null);
		}
		
		
	}

	public void deleteStudent(String theStudentId) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			
			int studentId = Integer.parseInt(theStudentId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "delete from student where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, studentId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
		
	}
	
}




