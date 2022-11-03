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
import gr.aueb.cf.teachersapp.service.exceptions.StudentNotFoundException;






@WebServlet("/UpdateStudentController")
public class UpdateStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	IStudentDAO studentDAO = new StudentDAOImpl();
	IStudentService studentServ = new StudentServiceImpl(studentDAO);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		StudentDTO oldStudentDTO = new StudentDTO();
		oldStudentDTO.setId(id);
		
		StudentDTO newStudentDTO = new StudentDTO();
		newStudentDTO.setFirstname(firstname);
		newStudentDTO.setLastname(lastname);
		
		try {
			studentServ.updateStudent(oldStudentDTO, newStudentDTO);
			request.setAttribute("student", newStudentDTO);
			request.getRequestDispatcher("/jsps/studentupdated.jsp").forward(request, response);
		} catch (SQLException | StudentNotFoundException e) {
			e.printStackTrace();
		}
	}
 }


