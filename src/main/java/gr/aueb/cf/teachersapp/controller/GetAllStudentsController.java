package gr.aueb.cf.teachersapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.cf.teachersapp.dao.IStudentDAO;
import gr.aueb.cf.teachersapp.dao.StudentDAOImpl;
import gr.aueb.cf.teachersapp.dto.StudentDTO;
import gr.aueb.cf.teachersapp.model.Student;
import gr.aueb.cf.teachersapp.service.IStudentService;
import gr.aueb.cf.teachersapp.service.StudentServiceImpl;





@WebServlet("/GetAllStudentsController")
public class GetAllStudentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	IStudentDAO teacherDAO = new StudentDAOImpl();
	IStudentService teacherService = new StudentServiceImpl(teacherDAO);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		/*
		 * String lastname = request.getParameter("lastname").trim(); StudentDTO
		 * studentDTO = new StudentDTO(); studentDTO.setLastname(lastname);
		 */
		
		try {
			List<Student> students = teacherService.GetAllStudents();
			
			if (students != null) {
				request.setAttribute("students", students);
				request.getRequestDispatcher("/jsps/students.jsp").forward(request, response);
			} else {
				request.setAttribute("studentsNotFound", true);
				request.getRequestDispatcher("/jsps/studentsmenu.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}