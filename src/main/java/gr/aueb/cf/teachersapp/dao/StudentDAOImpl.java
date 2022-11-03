package gr.aueb.cf.teachersapp.dao;

import static gr.aueb.cf.teachersapp.dao.dbutil.DBUtil.closeConnection;
import static gr.aueb.cf.teachersapp.dao.dbutil.DBUtil.openConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.cf.teachersapp.model.Student;


public class StudentDAOImpl implements IStudentDAO {

	@Override
	public void insert(Student student) throws SQLException{
			PreparedStatement pst = null;
		
		try {
			
			String sql = "INSERT INTO STUDENTS (FIRSTNAME, LASTNAME) VALUES (?, ?)";
					
			pst = openConnection().prepareStatement(sql);
			pst.setString(1,  student.getFirstname());
			pst.setString(2,  student.getLastname());
			
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
	public void update(Student oldStudent,Student newStudent) throws SQLException {
			PreparedStatement pst = null;
		
		try {
			
			String sql = "UPDATE STUDENTS SET FIRSTNAME = '" + newStudent.getFirstname() + "', " + "LASTNAME = '" 
					+ newStudent.getLastname() + "' WHERE ID = " + oldStudent.getId();
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
	public void delete(Student student) throws SQLException {
		
		PreparedStatement pst = null;
		
		try {
			

			String sql = "DELETE FROM STUDENTS WHERE ID =  ?";
			pst = openConnection().prepareStatement(sql);
			pst.setInt(1,  student.getId());
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
	public Student getStudent(int id) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Student student = null;
		
		try {
			
			String sql = "SELECT * FROM STUDENTS WHERE ID = " + id;
			
			pst = openConnection().prepareStatement(sql);
			rs =  pst.executeQuery();
				
			if (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("ID"));
				student.setFirstname(rs.getString("FIRSTNAME"));
				student.setLastname(rs.getString("LASTNAME"));
			}
		
			return student;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
	}

	@Override
	public List<Student> getAll() throws SQLException {
		
		PreparedStatement pst = null;
		List <Student> students = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT * FROM STUDENTS";
			pst = openConnection().prepareStatement(sql);
			rs =  pst.executeQuery();
				
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("ID"));
				student.setFirstname(rs.getString("FIRSTNAME"));
				student.setLastname(rs.getString("LASTNAME"));
				
				students.add(student);
			}
			
		
			return (students.size() > 0) ? students : null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
	}

}
