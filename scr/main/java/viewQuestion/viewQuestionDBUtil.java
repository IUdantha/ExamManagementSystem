package viewQuestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class viewQuestionDBUtil {
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
	
	
	
	public List<loadQuestion> validate(viewQuestion vq ) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		
		ArrayList<loadQuestion> listLoadQuestion = new ArrayList<>();
		
		try {
			String moduleTableName = vq.getFaculty() + "_" + vq.getYear() + "_" + vq.getMcode();
			
			String moduleTableNameQry = "SELECT * FROM " + moduleTableName;
			
			Statement st1 = con.createStatement();
			ResultSet rs = st1.executeQuery(moduleTableNameQry);
			
			while(rs.next()) {
				String qid = rs.getString(1);
				String question = rs.getString(2);
				String option1 = rs.getString(3);
				String option2 = rs.getString(4);
				String option3 = rs.getString(5);
				String option4 = rs.getString(6);
				String answer = rs.getString(7);
				
				loadQuestion listLoadQuestion1 = new loadQuestion(qid, question, option1, option2, option3, option4, answer);
				listLoadQuestion.add(listLoadQuestion1);
				
//				System.out.println(qid + " " + question + " " + option1 + " " + option2 + " " + option3 + "" + option4 + " " + answer);
			}
			
			
		} 
		catch (SQLException e) {
			System.out.println("Error: The table cannot be read. " + e);
		}
		
		return listLoadQuestion;
	}
	

}
