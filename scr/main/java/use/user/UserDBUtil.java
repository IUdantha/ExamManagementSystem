package use.user;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class UserDBUtil {
	
	//Related to login class
	
public static List<User> validateU(String userName, String password){
		
		//Create an arrayList object
		 ArrayList<User> User = new ArrayList<>();
		 
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
			 String sql = "select * from usert where username = '"+userName+"' and password='"+password+"'";
			 
			 ResultSet rs = stmt.executeQuery(sql);
			 
			 //next is a boolean method. if it is true then the UN and PW is correct
			 //And we take the data from the DB
			 if(rs.next()) {
				 int id = rs.getInt(1); //give the column id
				 String name = rs.getString(2);	 
				 String NIC = rs.getString(3);	 
				 String phone = rs.getString(4);
				 String email = rs.getString(5);
				 String userU = rs.getString(6);
				 String pwdU = rs.getString(7);
				 String userT = rs.getString(8);
				 
				
					 //create object
					 User u = new User(id,name,NIC,phone,email,userU,pwdU,userT);
					 //pass this object to array object
					 User.add(u);
				 
				 
				
			 }
			 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 //we should return this array object
		 return User;
	}

//Related to createAccount class
	//InsertUser Method
	//This method make a connection with the DB and insert the data into the DB
	//This method returns a boolean value to the servlet class
	//It detect whether the data was inserted successfully or not
	
	//We have to capture the data passed through the servlet
	public static boolean insertuser(String name, String NIC, String phone, String email, String username, String password, String userType) {
		
		boolean isSuccess = false;
		 
		//Create db connection
		 String url = "jdbc:mysql://localhost:3306/exammanagement";
		 String user = "root";
		 String pwd = "";
		 
		 try {

			 //Class.forName(className)
			 Class.forName("com.mysql.jdbc.Driver");
			 
			 //call the database
			 //DriverManager,Statement are classes
			 Connection con = DriverManager.getConnection(url, user, pwd);
			 Statement stmt = con.createStatement();
			 
			 //insert query
			 //pass the data to the database
			
				 
				 String sql = "insert into usert values (0,'"+name+"','"+NIC+"','"+phone+"','"+email+"','"+username+"','"+password+"','"+userType+"')";
				 //We don't create a object from resultSet here
				 //We assign the values to an integer variable
				 int rs = stmt.executeUpdate(sql);
				 
				 //executeUpdate method returns 2 values  
				 //If it returns 1 - success
				 //If returns 0 - unsuccess
				 
				 if(rs > 0) {
					 isSuccess = true;
				 }
				 else {
					 isSuccess = false;
				 }
					 
			 
		 } 
			 
			 catch(Exception e){
				 //To print the error if an error occurs
				 e.printStackTrace();
			 }
		 
			return isSuccess;
		 }
	
	
	//Update Details
	
		//Pass the variable name given in the updateservlet file
		public static boolean updateUser(String id, String name, String NIC, String phone, String email, String username, String userType) {
			
			
			boolean isSuccess = false;
			 
			//Create db connection
			 String url = "jdbc:mysql://localhost:3306/exammanagement";
			 String user = "root";
			 String pwd = "";
			 
			 try {

				 //Class.forName(className)
				 Class.forName("com.mysql.jdbc.Driver");
				 
				 //call the database
				 //DriverManager,Statement are classes
				 Connection con = DriverManager.getConnection(url, user, pwd);
				 Statement stmt = con.createStatement();
				 
				 //Give the name in the DB
				 String sql = "update usert set name = '"+name+"',NIC = '"+NIC+"',phone = '"+phone+"',email = '"+email+"',username = '"+username+"'  Where id = '"+id+"' ";
				 //We don't create a object from resultSet here
				 //We assign the values to an integer variable
				 int rs = stmt.executeUpdate(sql);
				 //executeUpdate method returns 2 values  
				 //If it returns 1 - success
				 //If returns 0 - unsuccess
				 
				 if(rs > 0) {
					 isSuccess = true;
				 }
				 else {
					 isSuccess = false;
				 }

		
			 }
			 catch(Exception e){
				 //To print the error if an error occurs
				 e.printStackTrace();
			 }
			 return isSuccess;
		}
		
		
		//Delete Details
		
			//Pass the variable name given in the updateservlet file
			public static boolean deleteUser(String id) {
				
				int convId = Integer.parseInt(id); //wrapper class
				
				boolean isSuccess = false;
				 
				//Create db connection
				 String url = "jdbc:mysql://localhost:3306/exammanagement";
				 String user = "root";
				 String pwd = "";
				 
				 try {

					 //Class.forName(className)
					 Class.forName("com.mysql.jdbc.Driver");
					 
					 //call the database
					 //DriverManager,Statement are classes
					 Connection con = DriverManager.getConnection(url, user, pwd);
					 Statement stmt = con.createStatement();
					 
					 //Give the name in the DB
					 String sql = "delete from usert Where id = '"+convId+"' ";
					 //We don't create a object from resultSet here
					 //We assign the values to an integer variable
					 int rs = stmt.executeUpdate(sql);
					 //executeUpdate method returns 2 values  
					 //If it returns 1 - success
					 //If returns 0 - unsuccess
					 
					 if(rs > 0) {
						 isSuccess = true;
					 }
					 else {
						 isSuccess = false;
					 }

			
				 }
				 catch(Exception e){
					 //To print the error if an error occurs
					 e.printStackTrace();
				 }
				 return isSuccess;
			}
			
			//Get User Details
			public static List<User> getUserDetails(String id) {
				// TODO Auto-generated method stub
				ArrayList<User> use = new ArrayList<>();
				 
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
					 int convId = Integer.parseInt(id); //wrapper class
					 //insert query
					 //we do the validation with the help of where clause
					 String sql = "select * from usert where id = '"+convId+"'";
					 
					 ResultSet rs = stmt.executeQuery(sql);
					 
					 //next is a boolean method. if it is true then the UN and PW is correct
					 //And we take the data from the DB
					 if(rs.next()) {
						 int id1 = rs.getInt(1); //give the column id
						 String name = rs.getString(2);	 
						 String NIC = rs.getString(3);	 
						 String phone = rs.getString(4);
						 String email = rs.getString(5);
						 String userU = rs.getString(6);
						 String pwdU = rs.getString(7);
						 String userT = rs.getString(8);
						 
						
							 //create object
							 User us = new User(id1,name,NIC,phone,email,userU,pwdU,userT);
							 //pass this object to array object
							 use.add(us);
						 
						 
						
					 }
					 
				 } //close try
				 catch(Exception e) {
					 e.printStackTrace();
				 } //close catch
				 
				 //we should return this array object
				 return use;
			}
			

}


