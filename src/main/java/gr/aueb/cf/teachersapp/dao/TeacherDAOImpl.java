package gr.aueb.cf.teachersapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.cf.teachersapp.model.Teacher;

import static gr.aueb.cf.teachersapp.dao.dbutil.DBUtil.openConnection;
import static gr.aueb.cf.teachersapp.dao.dbutil.DBUtil.closeConnection;

public class TeacherDAOImpl implements ITeacherDAO {

	@Override
	public void insert(Teacher teacher) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			
			String sql = "INSERT INTO TEACHERS (FIRSTNAME, LASTNAME) VALUES (?, ?)";
					//+ teacher.getFname() + "', '" + teacher.getSname() + "')";
			pst = openConnection().prepareStatement(sql);
			pst.setString(1,  teacher.getFname());
			pst.setString(2,  teacher.getSname());
			
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
	public void delete(Teacher teacher) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			
			//String sql = "DELETE FROM TEACHERS WHERE ID = " + teacher.getId();
			
			String sql = "DELETE FROM TEACHERS WHERE ID =  ?";
			pst = openConnection().prepareStatement(sql);
			pst.setInt(1,  teacher.getId());
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
	public void update(Teacher oldTeacher, Teacher newTeacher) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			
			String sql = "UPDATE TEACHERS SET FIRSTNAME = '" + newTeacher.getFname() + "', " + "LASTNAME = '" 
					+ newTeacher.getSname() + "' WHERE ID = " + oldTeacher.getId();
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
	public List<Teacher> getTeachersByLastname(String lastname) throws SQLException {
		PreparedStatement pst = null;
		List<Teacher> teachers = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT ID, FIRSTNAME, LASTNAME FROM TEACHERS WHERE LASTNAME LIKE '" + lastname + "%'";
			pst = openConnection().prepareStatement(sql);
			rs =  pst.executeQuery();
				
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(rs.getInt("ID"));
				teacher.setFname(rs.getString("FIRSTNAME"));
				teacher.setSname(rs.getString("LASTNAME"));
				
				teachers.add(teacher);
			}
			
			//if (teachers.size() > 0)  return teachers; else return null;
			return (teachers.size() > 0) ? teachers : null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
		
	}

	@Override
	public Teacher getTeacherById(int id) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Teacher teacher = null;
		
		try {
			
			String sql = "SELECT * FROM TEACHERS WHERE ID = " + id;
			
			pst = openConnection().prepareStatement(sql);
			rs =  pst.executeQuery();
				
			if (rs.next()) {
				teacher = new Teacher();
				teacher.setId(rs.getInt("ID"));
				teacher.setFname(rs.getString("FIRSTNAME"));
				teacher.setSname(rs.getString("LASTNAME"));
			}
		
			return teacher;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
	}

}
