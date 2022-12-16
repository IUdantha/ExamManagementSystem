package deleteResult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class deleteResultDBUtil {
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
	
	
	public void validate(deleteResult dr ) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		
		try {
			String deleteResultQry = "DELETE FROM studentmarks WHERE id = " + dr.getRid();
					
			
			Statement st1 = con.createStatement();
			st1.executeUpdate(deleteResultQry);
			
			
			System.out.println("Data deleted successfully");
		} catch (SQLException e) {
			System.out.println("Error: Query cannot be run " + e);
		}
		
	}

}
