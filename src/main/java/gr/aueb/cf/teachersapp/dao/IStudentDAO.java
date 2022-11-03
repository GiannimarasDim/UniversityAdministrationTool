package gr.aueb.cf.teachersapp.dao;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.cf.teachersapp.model.Student;

public interface IStudentDAO {

	 void insert(Student student) throws SQLException;
     void update(Student oldstudent,Student newStudent) throws SQLException;
     void delete(Student student) throws SQLException;
     Student getStudent(int id) throws SQLException;
     List <Student> getAll() throws SQLException;
}
