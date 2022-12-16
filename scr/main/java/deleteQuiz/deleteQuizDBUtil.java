package deleteQuiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class deleteQuizDBUtil {
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
	
	//declaring to the variable qustion number and quiz table name
	static public int noQ = 0;
	public String quiz_table_namescol = null;
	
	public void validate(deleteQuiz dq ) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		
		try {
			String moduleTableName = dq.getFaculty() + "_" + dq.getYear() + "_" + dq.getMcode();
			
			String deleteTableQry = "DROP TABLE " + moduleTableName;
			
			Statement st1 = con.createStatement();
			st1.executeUpdate(deleteTableQry);
			
			System.out.println("Delete Successed");
		} catch (SQLException e) {
			System.out.println("Error: Query cannot be run " + e);
		}
		
	}
}
