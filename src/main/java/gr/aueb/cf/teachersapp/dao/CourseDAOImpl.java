package gr.aueb.cf.teachersapp.dao;

import static gr.aueb.cf.teachersapp.dao.dbutil.DBUtil.closeConnection;
import static gr.aueb.cf.teachersapp.dao.dbutil.DBUtil.openConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.cf.teachersapp.model.Course;
import gr.aueb.cf.teachersapp.model.Student;

public class CourseDAOImpl implements ICourseDAO {

	@Override
	public void insert(Course course) throws SQLException {
		
		PreparedStatement pst = null;
		
		try {
			
			String sql = "INSERT INTO COURSES (Description, Teacher_Id) VALUES (?, ?)";
					
			pst = openConnection().prepareStatement(sql);
			pst.setString(1,  course.getDescription());
			pst.setInt(2,  course.getTeacherId());
			
			 pst.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}
		
	}

	@Override
	public void update(Course oldCourse, Course newCourse) throws SQLException {
		
		PreparedStatement pst = null;
		
		try {
			
			String sql = "UPDATE COURSES SET DESCRIPTION = '" + newCourse.getDescription() + "', " + "TEACHERS_ID = '" 
					+ newCourse.getTeacherId() + "' WHERE ID = " + oldCourse.getId();
			pst = openConnection().prepareStatement(sql);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
		
	}

	@Override
	public void delete(Course course) throws SQLException {
		
		PreparedStatement pst = null;
		
		try {
			

			String sql = "DELETE FROM COURSES WHERE Id =  ?";
			pst = openConnection().prepareStatement(sql);
			pst.setInt(1,  course.getId());
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}	
		
	}

	@Override
	public Course getCourse(String description) throws SQLException {
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		Course course = null;
		
		try {
			
			String sql = "SELECT * FROM COURSES WHERE Description= ?";
			
			pst = openConnection().prepareStatement(sql);
			pst.setString(1, description);
			rs =  pst.executeQuery();
				
			if (rs.next()) {
				course = new Course();
				course.setId(rs.getInt("ID"));
				course.setDescription(rs.getString("Description"));
				course.setTeacherId(rs.getInt("TEACHER_ID"));
			}
		
			return course;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
	}

	@Override
	public List<Course> getAll() throws SQLException {
		
		PreparedStatement pst = null;
		List <Course> courses = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT * FROM COURSES";
			pst = openConnection().prepareStatement(sql);
			rs =  pst.executeQuery();
				
			while (rs.next()) {
				Course course = new Course();
				course.setId(rs.getInt("ID"));
				course.setDescription(rs.getString("DESCRIPTION"));
				course.setTeacherId(rs.getInt("TEACHER_ID"));
				
				courses.add(course);
			}
			
			
			return (courses.size() > 0) ? courses : null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
	}

}
