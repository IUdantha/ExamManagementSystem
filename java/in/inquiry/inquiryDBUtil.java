package in.inquiry;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class inquiryDBUtil {


	//Insert data to the database
	public static boolean insertinquiry(String name, String email, String number,String faculty, String year, String inquirytype,String message, String filename) {
		 {
		
		 boolean isSuccess = false;
		 
		//Create db connection
		 String url = "jdbc:mysql://localhost:3306/exammanagement";
		 String user = "root";
		 String pwd = "";
		 
		 try {

			 //Class.forName(className)
			 Class.forName("com.mysql.jdbc.Driver");
			 
	
			 Connection con = DriverManager.getConnection(url, user, pwd);
			 Statement stmt = con.createStatement();

				 String sql = "insert into inquiry values (0,'"+name+"','"+email+"','"+number+"' '"+faculty+"','"+year+"','"+inquirytype+"''"+message+"','"+filename+"')";
				
				 int rs = stmt.executeUpdate(sql);
				 
	
				 if(rs > 0) {
					 isSuccess = true;
				 }
				 else {
					 isSuccess = false;
				 }
			 
		 }
		 //check errors
		 catch(Exception e){
			
			 e.printStackTrace();
		 }
		
		return isSuccess;
		 }
	
	}
	
	
//Get Data from the database 
	public static List<inquiry> validateT(String name, String email, String number, String faculty, String year, String inquirytype, String message, String filename){
			
			//Create an arrayList object
			 ArrayList<inquiry> inqu = new ArrayList<>();
			 
			 //Create database connection
			 String url = "jdbc:mysql://localhost:3306/exammanagement";
			 String user = "root";
			 String pwd = "";
			 
			 //Validate
			 
			 //To fix the errors without terminating the program
			 try {
				 //Sql 
				 
				 //Class.forName(className)
				 Class.forName("com.mysql.jdbc.Driver");
				 
				 //call the database
				 //DriverManager,Statement are classes
				 Connection con = DriverManager.getConnection(url, user, pwd);
				 Statement stmt = con.createStatement();
				 
				 //insert query
				 //we do the validation with the help of where clause
				 String sql = "select * from inquiry ";
				 
				 ResultSet rs = stmt.executeQuery(sql);
				 
				 //next is a boolean method. if it is true then the UN and PW is correct
				 //And we take the data from the DB
				 if(rs.next()) {
				 //give the column id
					 String namee = rs.getString(1);	 
					 String emaill= rs.getString(2);
					 String numberr = rs.getString(3);
					 String facultyy = rs.getString(4);
					 String yearr= rs.getString(5);
					 String inquirytypee= rs.getString(5);
					
					 String  emessage= rs.getString(6);
					 String filenamee= rs.getString(7);
					
		
						
						inquiry inq = new inquiry(namee,emaill,numberr,facultyy,yearr,inquirytypee,emessage,filenamee);
						 //pass this object to array object
						 inqu.add(inq);
					 
					 
					
				 }
				 
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }
			 
			
			 return inqu;
		}
}
