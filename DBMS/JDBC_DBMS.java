package Assignment;
import java.sql.*;
public class JDBC_DBMS {
	
	public static void main(String arg[]) {
			
		try {
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","pass@123");
			
			// Callable Statement (unparameterized)
			CallableStatement stmt1 = conn.prepareCall("{call getAllCustomer()}");
			stmt1.execute();
			ResultSet result1 = stmt1.getResultSet();
			System.out.println("Customers:");
			while(result1.next()) {
				System.out.println(result1.getInt(1) + " " +result1.getString(2) + " " +result1.getString(3));
			}
			
			// Callable Statement (parameterized)
			CallableStatement stmt2 = conn.prepareCall("{call getSalesOfficeEmployees(?)}");
			stmt2.setInt(1, 102);
			stmt2.execute();
			ResultSet result2 = stmt2.getResultSet();
			System.out.println("Employee working in sales office 102:");
			while(result2.next()) {
				System.out.println(result2.getInt(1) + " " +result2.getString(2) + " " +result2.getInt(3));
			}
			
			
			// Prepared Statement
			PreparedStatement insert_stmt = conn.prepareStatement("insert into salesoffice values(?,?,?)");
			insert_stmt.setInt(1,111);
			insert_stmt.setString(2, "Mumbai");
			insert_stmt.setLong(3, 1243298888);
			
			int records = insert_stmt.executeUpdate();
			System.out.println(records + " records inserted");
			
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	
}
