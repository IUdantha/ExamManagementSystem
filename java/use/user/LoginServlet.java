package use.user;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("uid"); //The name in the form(.jsp file)
		String password = request.getParameter("pass");
		String userType = request.getParameter("userType");
		
		HttpSession session = request.getSession();
		session.setAttribute("uid", username);
		session.setAttribute("userType", userType);
	
		
			//To take the data from student.java
			try {
			//because validate() is a static method, you can call it using the class
				List<User> userDetails = UserDBUtil.validateU (username,password);
			
			//Make a connection with HomeSTD.jsp file
			//What we should send to that new page
			
				request.setAttribute("userDetails", userDetails);
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
			
			if(userType.equals("std")) {
				//Redirect the data to the new page
				RequestDispatcher dis = request.getRequestDispatcher("Profile.jsp"); //Name of the file that data should be redirected to
				dis.forward(request, response);
			
			}
			else if(userType.equals("lec")) {
				RequestDispatcher dis = request.getRequestDispatcher("Profile.jsp"); //Name of the file that data should be redirected to
				dis.forward(request, response);
			}
			
			else if(userType.equals("examDep")) {
				RequestDispatcher dis = request.getRequestDispatcher("Profile.jsp"); //Name of the file that data should be redirected to
				dis.forward(request, response);
			}
		
		
	}
		
	

}
