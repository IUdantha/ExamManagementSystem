package updateQuestion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateQuestionServlet
 */
@WebServlet("/updateQuestionServlet")
public class updateQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Hello, I am here");
		String faculty = request.getParameter("faculty");
		String year = request.getParameter("year");
		String mcode = request.getParameter("mcode");
		String newQno = request.getParameter("newQno");
		String question = request.getParameter("question");
		String opt1 = request.getParameter("opt1");
		String opt2 = request.getParameter("opt2");
		String opt3 = request.getParameter("opt3");
		String opt4 = request.getParameter("opt4");
		String answer = request.getParameter("answer");
		
		updateQuestion uq1 = new updateQuestion(faculty, year, mcode, newQno, question, opt1, opt2, opt3, opt4, answer);
		
		updateQuestionDBUtil uqdb1 = new updateQuestionDBUtil();
		uqdb1.validate(uq1);
		
		RequestDispatcher dis = request.getRequestDispatcher("ExamLec.jsp");
		dis.forward(request, response);	
		
	}

}
