package use.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CustomerInsert
 */
@WebServlet("/CreateAccServlet")
public class CreateAccServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//To capture the data from the form and to save it
		//We use request method to save the data inside variables
		String name = request.getParameter("name"); //We use the name given in the form inside the parentheses 
		String NIC = request.getParameter("NIC");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String username = request.getParameter("uid");
		String password = request.getParameter("psw");
		String userType = request.getParameter("userType");
		
	
		//Call the insertUser method in the userDBUtil
		//Use above variable names as argument names
		
		boolean isTrue; //To capture the return boolean value
		
		isTrue = UserDBUtil.insertuser(name, NIC, phone, email, username, password, userType);
		
		//check whether the db connection is successful
		if(isTrue == true) {
			
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
		
		}
		else {
			
			RequestDispatcher dis2 = request.getRequestDispatcher("signUp.jsp");
			dis2.forward(request, response);
			
		}
		
	}

}
