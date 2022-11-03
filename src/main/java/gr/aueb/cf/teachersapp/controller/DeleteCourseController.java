package gr.aueb.cf.teachersapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.cf.teachersapp.dao.CourseDAOImpl;
import gr.aueb.cf.teachersapp.dao.ICourseDAO;
import gr.aueb.cf.teachersapp.dao.IStudentDAO;
import gr.aueb.cf.teachersapp.dao.StudentDAOImpl;
import gr.aueb.cf.teachersapp.dto.CourseDTO;
import gr.aueb.cf.teachersapp.dto.StudentDTO;
import gr.aueb.cf.teachersapp.service.CourseServiceImpl;
import gr.aueb.cf.teachersapp.service.ICourseService;
import gr.aueb.cf.teachersapp.service.IStudentService;
import gr.aueb.cf.teachersapp.service.StudentServiceImpl;
import gr.aueb.cf.teachersapp.service.exceptions.CourseNotFoundException;
import gr.aueb.cf.teachersapp.service.exceptions.StudentNotFoundException;


@WebServlet("/DeleteCourseController")
public class DeleteCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ICourseDAO courseDAO = new CourseDAOImpl();
	ICourseService courseServ = new CourseServiceImpl(courseDAO);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		int id = Integer.parseInt(request.getParameter("id").trim());	
		String description = request.getParameter("description").trim();	
		int teacherId = Integer.parseInt(request.getParameter("teacherid").trim());
		
		
		CourseDTO courseDTO  = new CourseDTO ();
		courseDTO .setId(id);
		courseDTO .setDescription(description);
		courseDTO .setTeacherId(teacherId);
		
		
		try {
			courseServ.deleteCourse(courseDTO);
			
			request.setAttribute("course", courseDTO);
			request.getRequestDispatcher("/jsps/coursedeleted.jsp").forward(request, response);	
		} catch (CourseNotFoundException e1) {
			request.setAttribute("deleteAPIError", true);
			request.getRequestDispatcher("/jsps/courses.jsp").forward(request, response);
		} catch (SQLException e2) {
			request.setAttribute("deleteAPIError", true);
			request.getRequestDispatcher("/jsps/courses.jsp").forward(request, response);
	
	}
	}
}
