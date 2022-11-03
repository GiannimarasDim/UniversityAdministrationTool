package gr.aueb.cf.teachersapp.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.cf.teachersapp.dto.StudentDTO;
import gr.aueb.cf.teachersapp.model.Student;
import gr.aueb.cf.teachersapp.service.exceptions.StudentNotFoundException;


public interface IStudentService {
	
	/**
	 * Inserts a new Student
	 * @param studentDTO
	 * 		the object that provides the data for the update
	 * @throws SQLException 
	 * 		in case of error during the SQL Update
	 */
	
	void insertStudent(StudentDTO studentDTO) throws SQLException;
	
	/**
	 * Updates an already existing student
	 * @param oldstudentDTO
	 * 		the object to be updated
	 * @param newStudentDTO
	 * 		the object carrying the data for the update
	 * @throws SQLException
	 * 		in case of error during the SQL Insert
	 * @throws StudentNotFoundException
	 * 		in case the student to updated,doesn't exist
	 */
	
    void updateStudent(StudentDTO oldstudentDTO,StudentDTO newStudentDTO) throws SQLException,StudentNotFoundException;
    
  /**
   * Deletes a student identified by their id
   * @param studentDTO
   * 	the object carrying the data of the student that
   * 	is about to be deleted
   * @throws SQLException
   * 	in case of error during the SQL Delete
 * @throws StudentNotFoundException 
 * 		in case the student is not found
   */
    
    void deleteStudent(StudentDTO studentDTO) throws SQLException, StudentNotFoundException;
    
    /**
     * Gets the Student identified by a specific id
     * @param id
     * 	the id of the student the user is going to use to find 
     * 	a specific student
     * @return 
     * 	the result of the search
     * @throws SQLException
     * 	in case of error during the SQL search
     */
    
    Student GetStudent(int id) throws SQLException;
    
    /**
     * Gets a list of all the Students to the caller
     * @return
     * 	the list of the Student the user asked for
     * @throws SQLException
     * 	in case of error during the SQL search
     * 	
     */
    List <Student> GetAllStudents() throws SQLException;

}
