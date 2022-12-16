package addQuestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class addQuestionDBUtil {
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
	
	public void validate(addQuestion aq ) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		
		try {
			String moduleTablenameQry = "select * from exammanagement.quizdetails where qid = (select max(qid) from exammanagement.quizdetails)";
			
			Statement st1 = con.createStatement();
			ResultSet rs = st1.executeQuery(moduleTablenameQry);
			
			
			while(rs.next()) {
				noQ = rs.getInt(5);
				quiz_table_namescol = rs.getString(8);
			}
			System.out.println(noQ + " " + quiz_table_namescol);
//			System.out.println(quiz_table_namescol);
			
			String addQuestionQry = "INSERT INTO " + quiz_table_namescol + 
									"(qid, question, option1, option2, option3, option4, answer) VALUES(0, '" + 
									aq.getQuestion() + "','" + aq.getOpt1() + "','" + aq.getOpt2() + "','" + aq.getOpt3() + 
									"','" + aq.getOpt4() + "','" + aq.getAnswer() + "')";
			Statement st2 = con.createStatement();
			st2.executeUpdate(addQuestionQry);
			
			
			System.out.println("Data inserted successfully");
		} catch (SQLException e) {
			System.out.println("Error: Query cannot be write " + e);
		}
		
	}
}
