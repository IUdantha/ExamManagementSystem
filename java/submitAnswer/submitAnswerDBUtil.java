package submitAnswer;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class submitAnswerDBUtil {
	
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
	public int noQtable(String tableName) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		int noQ = 0;
		try {
			String noQtableQry = "SELECT noQ FROM quizdetails WHERE quiz_table_namescol = '" + tableName + "'";
			
			Statement st1 = con.createStatement();
			ResultSet rs = st1.executeQuery(noQtableQry);
			
			
			while(rs.next()) {
				noQ = rs.getInt(1);
			}
		}
		catch(SQLException e) {
			System.out.println("Error: Query cannot be write " + e);
		}
		
		return noQ;
		
	}
	
	public int qValidate(ArrayList<String> ans, String table) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		
		int marks = 0;
	
		try {
			String realAns = "SELECT answer FROM " + table;
			
			Statement st1 = con.createStatement();
			ResultSet rs = st1.executeQuery(realAns);
			
			ArrayList<String> realAnsAL = new ArrayList<String>();
			
			
			while(rs.next()) {
				realAnsAL.add(rs.getString(1));

			}
			
//			for(int i = 0; i < ans.size(); i++) {
//				System.out.println(ans.get(i));
//			}
//			
//			System.out.println("\n\n\nThis is real answers");
//			for(int i = 0; i < realAnsAL.size(); i++) {
//				System.out.println(realAnsAL.get(i));
//			}
			
			for(int i = 0; i < ans.size(); i++) {
				if (ans.get(i).equals(realAnsAL.get(i))) {
					marks++;
				}
			}
			
			
			
		}
		catch(SQLException e) {
			System.out.println("Error: Query cannot be write " + e);
		}

		

		
		return marks;
		
	}
	
	public void storeMarks(String sid, String table, int marks){
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		
		try {
		String addMarksQry= "INSERT INTO studentmarks VALUES (0, '" + sid + "', '" + table + "', " + marks + ")";
		
		Statement st1 = con.createStatement();
		st1.executeUpdate(addMarksQry);
		
	
		}
		catch(SQLException e) {
			System.out.println("Marks not added successfully" + e);
		}
		
	}

}
