package examiner.exam;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class viewExaminerServlet
 */
@WebServlet("/viewExaminerServlet")
public class viewExaminerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String faculty = request.getParameter("faculty"); //The name in the form(.jsp file)
		String year = request.getParameter("year");
		
		
			//To take the data from student.java
			try {
			
			//because validate() is a static method, you can call it using the class
			List<examiner> examinerDetails = examinerDBUtil.validateEx(faculty,year);
			
			//Make a connection with HomeSTD.jsp file
			//What we should send to that new page
			request.setAttribute("examinerDetails", examinerDetails);
			
			System.out.println(examinerDetails);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			//Redirect the data to the new page
			RequestDispatcher dis = request.getRequestDispatcher("viewExaminer.jsp"); //Name of the file that data should be redirected to
			dis.forward(request, response);
			
			
			}
		
}
