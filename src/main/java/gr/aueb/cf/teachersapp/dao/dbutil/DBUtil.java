package gr.aueb.cf.teachersapp.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection conn;
	
	/**
	 * No instances will be available
	 */
	private DBUtil() {}
	
	public static Connection openConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			String url = "jdbc:mysql://localhost:3306/teachersDB?serverTimezone=UTC";
			String username = "Dimitris2";
			String password = "1234";
			
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
			
		}
	}
	
	
	public static void closeConnection() throws SQLException {
		conn.close();
	}
}

