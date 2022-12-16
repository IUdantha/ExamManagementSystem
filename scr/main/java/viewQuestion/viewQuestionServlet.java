package viewQuestion;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import submitAnswer.submitAnswer;

/**
 * Servlet implementation class viewQuestionServlet
 */
@WebServlet("/viewQuestionServlet")
public class viewQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewQuestionServlet() {
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
		
		viewQuestion vq1 = new viewQuestion(faculty, year, mcode);
		
		//passs table name to submitanswer class
		submitAnswer sa1 = new submitAnswer();
		
		viewQuestionDBUtil vqdb1 = new viewQuestionDBUtil();
		
//		System.out.println(vqdb1.validate(vq1));
		
		request.setAttribute("loadQuestion", vqdb1.validate(vq1));
		request.setAttribute("table", vq1.createTableName());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("showQuestion.jsp");
        dispatcher.forward(request, response);
	}

}
