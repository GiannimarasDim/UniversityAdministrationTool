package gr.aueb.cf.teachersapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.cf.teachersapp.dao.IStudentDAO;
import gr.aueb.cf.teachersapp.dao.StudentDAOImpl;
import gr.aueb.cf.teachersapp.dto.StudentDTO;
import gr.aueb.cf.teachersapp.service.IStudentService;
import gr.aueb.cf.teachersapp.service.StudentServiceImpl;



@WebServlet("/InsertStudentController")
public class InsertStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IStudentDAO studentDAO = new StudentDAOImpl();
	IStudentService studentServ = new StudentServiceImpl(studentDAO);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
			
		String firstname = request.getParameter("firstName").trim();
		String lastname = request.getParameter("lastName").trim();
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setFirstname(firstname);
		studentDTO.setLastname(lastname);
	
		try {
			studentServ.insertStudent(studentDTO);
			request.setAttribute("insertedStudent", studentDTO);
			request.getRequestDispatcher("/jsps/studentinserted.jsp").forward(request, response);
		} catch (SQLException e2) {
			e2.printStackTrace();
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/studentsmenu.jsp").forward(request, response);
		}
	}
	
}