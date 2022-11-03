package gr.aueb.cf.teachersapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.cf.teachersapp.dao.ITeacherDAO;
import gr.aueb.cf.teachersapp.dao.TeacherDAOImpl;
import gr.aueb.cf.teachersapp.dto.TeacherDTO;
import gr.aueb.cf.teachersapp.service.ITeacherService;
import gr.aueb.cf.teachersapp.service.TeacherServiceImpl;
import gr.aueb.cf.teachersapp.service.exceptions.TeacherNotFoundException;

@WebServlet("/delete")
public class DeleteTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ITeacherDAO teacherDAO = new TeacherDAOImpl();
	ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
	
		int id = Integer.parseInt(request.getParameter("id").trim());	
		String firstname = request.getParameter("fname").trim();	
		String lastname = request.getParameter("sname").trim();	
		
		TeacherDTO teacherDTO = new TeacherDTO();
		teacherDTO.setId(id);
		teacherDTO.setFname(firstname);
		teacherDTO.setSname(lastname);
		
		
		try {
			teacherServ.deleteTeacher(teacherDTO);
			
			request.setAttribute("teacher", teacherDTO);
			request.getRequestDispatcher("/jsps/teacherdeleted.jsp").forward(request, response);	
		} catch (TeacherNotFoundException e1) {
			request.setAttribute("deleteAPIError", true);
			request.getRequestDispatcher("/jsps/teachers.jsp").forward(request, response);
		} catch (SQLException e2) {
			request.setAttribute("deleteAPIError", true);
			request.getRequestDispatcher("/jsps/teachers.jsp").forward(request, response);
		}
	}
}

