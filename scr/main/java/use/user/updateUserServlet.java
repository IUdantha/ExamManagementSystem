package use.user;


import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class updateUserServlet
 */
@WebServlet("/updateUserServlet")
public class updateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id"); //Give the name in the form update.jsp
		String name = request.getParameter("name"); 
		String NIC = request.getParameter("NIC"); 
		String phone = request.getParameter("phone"); 
		String email = request.getParameter("email"); 
		String username = request.getParameter("username"); 
		String userType = request.getParameter("userType"); 
		
	
		
		try {
			
		//Call the update method
		boolean isTrue;
		
		isTrue = UserDBUtil.updateUser(id,name,NIC,phone, email, username, userType);
			
			if(isTrue == true) {
				
				List<User> userDetails = UserDBUtil.getUserDetails(id);
				request.setAttribute("userDetails", userDetails);
				
				RequestDispatcher dis = request.getRequestDispatcher("Profile.jsp");
				dis.forward(request,  response);
				
				System.out.println("Working");
			}
			else {
				RequestDispatcher dis = request.getRequestDispatcher("updateUser.jsp");
				dis.forward(request,  response);
			}
		
		}
			
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
}
	
