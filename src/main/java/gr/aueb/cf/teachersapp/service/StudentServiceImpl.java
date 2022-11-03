package gr.aueb.cf.teachersapp.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.cf.teachersapp.dao.IStudentDAO;
import gr.aueb.cf.teachersapp.dto.StudentDTO;
import gr.aueb.cf.teachersapp.model.Student;
import gr.aueb.cf.teachersapp.model.Teacher;
import gr.aueb.cf.teachersapp.service.exceptions.StudentNotFoundException;


public class StudentServiceImpl implements IStudentService {
	
	private final IStudentDAO studentDAO;
	
	public StudentServiceImpl(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void insertStudent(StudentDTO studentDTO) throws SQLException {
		Student student=new Student();
		student.setFirstname(studentDTO.getFirstname());
		student.setLastname(studentDTO.getLastname());
		
		try {
			
			studentDAO.insert(student); 
			
		} catch (SQLException e) {
			
			throw e;
		}
		
	}

	@Override
	public void updateStudent(StudentDTO oldStudentDTO, StudentDTO newStudentDTO)
			throws SQLException,StudentNotFoundException {
		
		
				Student studentToUpdate = new Student();
				studentToUpdate.setId(oldStudentDTO.getId());
				
				
				Student newStudent = new Student();
				newStudent.setLastname(newStudentDTO.getLastname());
				newStudent.setFirstname(newStudentDTO.getFirstname());
				
				
				try {
					
					
					 if (studentDAO.getStudent(studentToUpdate.getId()) != null ) {
					  
					 studentToUpdate.setId(studentDAO.getStudent(studentToUpdate.getId()).getId());
					 
					
					  studentDAO.update(studentToUpdate, newStudent);
					  }
					
					else {
						
						throw new StudentNotFoundException(studentToUpdate);
					}
						
					} catch (SQLException | StudentNotFoundException e) {
						
						throw e;
					}
		
	}

	@Override
	public void deleteStudent(StudentDTO studentDTO) throws SQLException ,StudentNotFoundException{
		
		Student studentToDelete = new Student();
		studentToDelete.setId(studentDTO.getId());
		
		
		try {
			if (studentDAO.getStudent(studentToDelete.getId()) != null ) {
				
				studentToDelete.setId(studentDAO.getStudent(studentToDelete.getId()).getId());
				studentDAO.delete(studentToDelete);
				
			} else {
				
			throw new StudentNotFoundException(studentToDelete);
			
			}
			
		} catch (SQLException | StudentNotFoundException  e) {  // |
			
			throw e;
		}
		
	}

	@Override
	public Student GetStudent(int id) throws SQLException {
		try {
			
			return studentDAO.getStudent(id);
			
		} catch (SQLException e) {
			
			throw e;
		}
	}

	@Override
	public List<Student> GetAllStudents() throws SQLException {
		
		try {
			
			return studentDAO.getAll();
			
		} catch (SQLException e) {
			
			throw e;
		}
	}

}
