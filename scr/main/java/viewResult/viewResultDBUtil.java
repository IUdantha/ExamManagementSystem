package viewResult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class viewResultDBUtil {
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
	
	
	public List<result> resultList() {
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		
		ArrayList<result> loadResult = new ArrayList<>();
		
		try {
			String resultQry = "SELECT * FROM studentmarks";
			
			Statement st1 = con.createStatement();
			ResultSet rs = st1.executeQuery(resultQry);
			
			while(rs.next()) {
				String id = rs.getString(1);
				String sid = rs.getString(2);
				String table = rs.getString(3);
				String marks = rs.getString(4);
				
//				System.out.println(id + " " + sid + " " + table + " " + marks);
				
				result rslt1 = new result(id, sid, table, marks);
				loadResult.add(rslt1);
				
			}
			
			
		} 
		catch (SQLException e) {
			System.out.println("Error: The table cannot be read. " + e);
		}
		
		return loadResult;
	}

}
