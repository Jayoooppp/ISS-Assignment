package Assignment;

import java.sql.*;

public class JDBC {
	
	public static void main(String arg[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practise","root","pass@123");
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from department");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " +rs.getString(2) + " " +rs.getInt(3));
			}
			conn.close();
			
		}catch(Exception e) {
			// Handle Exception
			e.printStackTrace();
		}
	}

}
