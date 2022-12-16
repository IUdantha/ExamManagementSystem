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
 * Servlet implementation class deleteUserServlet
 */
@WebServlet("/deleteUserServlet")
public class deleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String id = request.getParameter("id"); //Give the name in the form delete.jsp
			
			boolean isTrue;
			
			isTrue = UserDBUtil.deleteUser(id);
			
			if(isTrue == true) {
				RequestDispatcher dis = request.getRequestDispatcher("signUp.jsp");
				dis.forward(request,  response);
			}
			else {
			
				List<User> userDetails = UserDBUtil.getUserDetails(id);
				request.setAttribute("userDetails", userDetails);
				
				RequestDispatcher dis = request.getRequestDispatcher("Profile.jsp");
				dis.forward(request,  response);
			}
			
	}

}
