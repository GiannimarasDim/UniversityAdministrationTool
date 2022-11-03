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
import gr.aueb.cf.teachersapp.dto.CourseDTO;
import gr.aueb.cf.teachersapp.service.CourseServiceImpl;
import gr.aueb.cf.teachersapp.service.ICourseService;
import gr.aueb.cf.teachersapp.service.exceptions.CourseNotFoundException;




@WebServlet("/UpdateCourseController")
public class UpdateCourseController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	ICourseDAO courseDAO = new CourseDAOImpl();
	ICourseService studentServ = new CourseServiceImpl(courseDAO);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String description = request.getParameter("description");
		int  teacherID = Integer.parseInt(request.getParameter("teacherid"));
		
		CourseDTO oldCourseDTO = new CourseDTO();
		oldCourseDTO.setId(id);
		
		CourseDTO newCourseDTO = new CourseDTO();
		newCourseDTO.setDescription(description);
		newCourseDTO.setTeacherId(teacherID);
		
		try {
			studentServ.updateCourse(oldCourseDTO, newCourseDTO);
			request.setAttribute("course", newCourseDTO);
			request.getRequestDispatcher("/jsps/courseupdated.jsp").forward(request, response);
		} catch (SQLException | CourseNotFoundException e) {
			e.printStackTrace();
		}
	}

}
