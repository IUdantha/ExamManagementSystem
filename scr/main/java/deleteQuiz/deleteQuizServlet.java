package deleteQuiz;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteQuizServlet
 */
@WebServlet("/deleteQuizServlet")
public class deleteQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteQuizServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String faculty = request.getParameter("faculty");
		String year = request.getParameter("year");
		String mcode = request.getParameter("mcode");
		
		deleteQuiz dq1 = new deleteQuiz(faculty, year, mcode);
		
		deleteQuizDBUtil dqdb1 = new deleteQuizDBUtil();
		dqdb1.validate(dq1);
		
		RequestDispatcher dis = request.getRequestDispatcher("ExamLec.jsp");
		dis.forward(request, response);
		
	}

}
