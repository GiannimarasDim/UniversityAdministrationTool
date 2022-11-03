package gr.aueb.cf.teachersapp.dao;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.cf.teachersapp.model.Course;


public interface ICourseDAO {
	
	void insert(Course course) throws SQLException;
    void update(Course oldCourse,Course newCourse) throws SQLException;
    void delete(Course course) throws SQLException;
    Course getCourse(String description) throws SQLException;
    List <Course> getAll() throws SQLException;

}
