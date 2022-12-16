package updateQuestion;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class updateQuestionDBUtil {

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
	
	public void validate(updateQuestion uq ) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		
		try {
			String selectedUpdateTable = uq.getFaculty() + "_" + uq.getYear() + "_" + uq.getMcode();
			String updateQuestionQry = "UPDATE " + selectedUpdateTable + " SET question = '" + uq.getQuestion() + 
					"', option1 = '" + uq.getOpt1() + "', option2 = '" + uq.getOpt2() + "', option3 = '" + uq.getOpt3() + 
					"', option4 = '" + uq.getOpt4() + "', answer = '" + uq.getOpt1() + "' WHERE qid = " + uq.getNewQno();
			
			Statement st1 = con.createStatement();
			st1.executeUpdate(updateQuestionQry);
			
			
			System.out.println("Data updated successfully");
		} catch (SQLException e) {
			System.out.println("Error: Query cannot be run " + e);
		}
		
	}
}
