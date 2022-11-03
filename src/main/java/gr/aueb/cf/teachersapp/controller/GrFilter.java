package gr.aueb.cf.teachersapp.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/*")
public class GrFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			 throws IOException, ServletException {
	  
		 ((HttpServletRequest) request).setCharacterEncoding("UTF-8");
		 chain.doFilter(request,  response);
	 
	 }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
