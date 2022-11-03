package gr.aueb.cf.teachersapp.service;

import java.sql.SQLException;
import java.util.List;
import gr.aueb.cf.teachersapp.dto.CourseDTO;
import gr.aueb.cf.teachersapp.model.Course;
import gr.aueb.cf.teachersapp.service.exceptions.CourseNotFoundException;



public interface ICourseService {

	/**
	 * Inserts a new course
	 * @param courseDTO
	 * 		the object that provides the data for the update
	 * @throws SQLException 
	 * 		in case of error during the SQL Update
	 */
	
	void insertCourse(CourseDTO courseDTO) throws SQLException;
	
	/**
	 * Updates an already existing student
	 * @param oldCourseDTO
	 * 		the object to be updated
	 * @param newCourseDTO
	 * 		the object carrying the data for the update
	 * @throws SQLException
	 * 		in case of error during the SQL Insert
	 * @throws CourseNotFoundException
	 * 		in case the course to updated,doesn't exist
	 */
	
    void updateCourse(CourseDTO oldCourseDTO,CourseDTO newCourseDTO) throws SQLException,CourseNotFoundException;
    
  /**
   * Deletes a course identified by its id
   * @param courseDTO
   * 	the object carrying the data of the course that
   * 	is about to be deleted
   * @throws SQLException
   * 	in case of error during the SQL Delete
   */
    
    void deleteCourse(CourseDTO courseDTO) throws SQLException,CourseNotFoundException;
    
    /**
     * Gets the Course identified by a specific id
     * @param id
     * 	the id  the user is going to use to find 
     * 	a specific course
     * @return 
     * 	the result of the search
     * @throws SQLException
     * 	in case of error during the SQL search
     */
    
    Course GetCourse(String description) throws SQLException;
    
    /**
     * Gets a list of all the Courses to the caller
     * @return
     * 	the list of the Courses the user asked for
     * @throws SQLException
     * 	in case of error during the SQL search
     * 	
     */
    List <Course> GetAllCourses() throws SQLException;

	
}
