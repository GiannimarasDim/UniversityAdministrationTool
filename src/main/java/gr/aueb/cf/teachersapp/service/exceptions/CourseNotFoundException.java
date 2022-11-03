package gr.aueb.cf.teachersapp.service.exceptions;

import gr.aueb.cf.teachersapp.model.Course;


public class CourseNotFoundException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	public CourseNotFoundException(Course course) {
		super("Course with id = " + course.getId() + " was not found");
	}

}
