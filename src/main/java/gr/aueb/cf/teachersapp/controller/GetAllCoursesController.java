package gr.aueb.cf.teachersapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.cf.teachersapp.dao.CourseDAOImpl;
import gr.aueb.cf.teachersapp.dao.ICourseDAO;
import gr.aueb.cf.teachersapp.model.Course;
import gr.aueb.cf.teachersapp.service.CourseServiceImpl;
import gr.aueb.cf.teachersapp.service.ICourseService;



@WebServlet("/GetAllCoursesController")
public class GetAllCoursesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	ICourseDAO courseDAO = new CourseDAOImpl();
	ICourseService courseService = new CourseServiceImpl(courseDAO);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		
		
		try {
			List<Course> courses = courseService.GetAllCourses();
			
			if (courses != null) {
				request.setAttribute("courses", courses);
				request.getRequestDispatcher("/jsps/courses.jsp").forward(request, response);
			} else {
				request.setAttribute("coursesNotFound", true);
				request.getRequestDispatcher("/jsps/coursesmenu.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
