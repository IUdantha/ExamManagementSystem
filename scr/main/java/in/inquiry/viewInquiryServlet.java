package in.inquiry;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class viewInquiryServlet
 */
@WebServlet("/viewInquiryServlet")
public class viewInquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		String faculty = request.getParameter("faculty"); //The name in the form(.jsp file)
		String year = request.getParameter("year");
		String inquirytype = request.getParameter("inquirytype");
		String message = request.getParameter("message");
		String filename = request.getParameter("filename");
		
		
			//To take the data from student.java
			try {
			
			//because validate() is a static method, you can call it using the class
			List<inquiry> inquiryDetails = inquiryDBUtil.validateT(name, email, number, faculty, year, inquirytype, message,filename);
			
			//Make a connection with HomeSTD.jsp file
			//What we should send to that new page
			request.setAttribute("inquiryDetails",inquiryDetails );
			
			System.out.println(inquiryDetails );
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			//Redirect the data to the new page
			RequestDispatcher dis = request.getRequestDispatcher("viewInquiry.jsp"); //Name of the file that data should be redirected to
			dis.forward(request, response);
			
			
			}

}
