package time.timetable;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteTimetableServlet
 */
@WebServlet("/deleteTimetableServlet")
public class deleteTimetableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	String faculty = request.getParameter("faculty"); //We use the name given in the form inside the parentheses 
	String year = request.getParameter("year");//Give the name in the form delete.jsp
	System.out.print("working");
	System.out.println(faculty + "_" + year);
		try {
			
				boolean isTrue;
				
				isTrue = timetableDBUtil.deleteTimetable(faculty, year);
				System.out.println(isTrue);
				
				if(isTrue == true) {
					RequestDispatcher dis = request.getRequestDispatcher("viewTimetable.jsp");
					dis.forward(request,  response);
					System.out.println("Its true");
				}
				else {
			
					RequestDispatcher dis = request.getRequestDispatcher("Home.jsp");
					dis.forward(request,  response);
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

			
	}


}
