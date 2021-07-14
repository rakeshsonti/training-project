package com.mfcwl.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDbUtil studentDbUtil;
	
	@Resource(name = "jdbc/web_student_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String theCommand = request.getParameter("command");
			
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			log(theCommand);
			switch (theCommand) {
			
			case "LIST":
				listStudent(request, response);
				break;
								
			case "LOAD":
				loadStudent(request, response);
				break;
				
			case "UPDATE":
				updateStudent(request, response);
				break;
			
			case "DELETE":
				deleteStudent(request, response);
				break;
				
			default:
				listStudent(request, response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			throw new ServletException(e);
		}
		
	}
	
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String theStudentId = request.getParameter("studentId");
		
		// delete student from database
		studentDbUtil.deleteStudent(theStudentId);
		
		// send them back to "list students" page
		listStudent(request, response);
		
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id = Integer.parseInt(request.getParameter("studentId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		Student newStudent = new Student(id, firstName, lastName, email);
		
		
		
		studentDbUtil.updateStudent(newStudent);
		
		listStudent(request, response);
		
		
	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
		
		String theStudentId = request.getParameter("studentId");
		
		Student theStudent = studentDbUtil.getStudent(theStudentId);
		
		System.out.println(theStudentId);
		
		request.setAttribute("THE_STUDENT", theStudent);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			addStudent(request, response);
			
			
		} catch (Exception e) {
			throw new ServletException();
		}
		
	}
	
	
	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		Student newStudent = new Student(firstName, lastName, email);
		
		studentDbUtil.addStudent(newStudent);
		
		
		
		response.sendRedirect(request.getContextPath() + "/StudentControllerServlet?command=LIST");
		
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		//get students from db util
		List<Student> students = studentDbUtil.getStudents();
		
		request.setAttribute("studentList", students);
		
		//send to jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
		
	}

}


