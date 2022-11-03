package gr.aueb.cf.teachersapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		
		String eMail = request.getParameter("eMail");
		String password = request.getParameter("password");
		
		// We assume here that could call a service for validating credentials
		if (eMail.equals("giannimarasdi@gmail.com") && (password.contentEquals("1234"))) {
			// dispatch request to search menu page
			request.getRequestDispatcher("/jsps/afterLogin.jsp").forward(request, response);
		} else {
			request.setAttribute("error", true);
			request.getRequestDispatcher("/jsps/login.jsp").forward(request, response);	
		}
				
	}
	
	
}