package updateResult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class updateResultDBUtil {
	private String dbUrl = "jdbc:mysql://localhost:3306/exammanagement";
	private String dbUname = "root";
	private String dbPassword = "";
	private String dbDriver = "com.mysql.jdbc.Driver";
	
	public void loadDriver(String dbDriver) {
		try {
		Class.forName(dbDriver);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
		con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	
	
	public void validate(updateResult ur ) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		
		try {
			String updateResultQry = "UPDATE studentmarks SET sid = '" + ur.getSid() + 
					"', qType = '" + ur.getqType() + "', marks = " + ur.getMarks() + " WHERE id = " + ur.getRid();
			
			Statement st1 = con.createStatement();
			st1.executeUpdate(updateResultQry);
			
			
			System.out.println("Data updated successfully");
		} catch (SQLException e) {
			System.out.println("Error: Query cannot be run " + e);
		}
		
	}

}
