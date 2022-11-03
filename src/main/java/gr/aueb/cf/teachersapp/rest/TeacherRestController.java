package gr.aueb.cf.teachersapp.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import gr.aueb.cf.teachersapp.dao.ITeacherDAO;
import gr.aueb.cf.teachersapp.dao.TeacherDAOImpl;
import gr.aueb.cf.teachersapp.model.Teacher;
import gr.aueb.cf.teachersapp.service.ITeacherService;
import gr.aueb.cf.teachersapp.service.TeacherServiceImpl;

@WebServlet("/teachersrest")
public class TeacherRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ITeacherDAO teacherDAO = new TeacherDAOImpl();
	ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("application/json; charset=UTF-8");
		
		String lastname = request.getParameter("lastname");
		
		List<Teacher> teachers = new ArrayList<>();		
		Gson gson = new Gson();
		String jsonString;
		
		try {
			teachers = teacherServ.getTeacherByLastname(lastname);
			if (teachers != null) {
				jsonString = gson.toJson(teachers);
				System.out.println(jsonString);
				PrintWriter out = response.getWriter();
				out.write(jsonString);
			} else {
				response.getWriter().write("{}");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
