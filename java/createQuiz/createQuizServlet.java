package createQuiz;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class createQuizServlet
 */
@WebServlet("/createQuizServlet")
public class createQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createQuizServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    static int i = 0;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get user data from createQuiz.jsp file and load to parameters
		String faculty = request.getParameter("faculty");
		String year = request.getParameter("year");
		String mcode = request.getParameter("mcode");
		String noQ = request.getParameter("noQ");
		String enrollKey = request.getParameter("enrollkey");
		String quizPass = request.getParameter("quizPass");
		
		System.out.println("No of questions : " + noQ);
//		System.out.println("until this successful");
		
		//pass data to createQuiz.java class using constructor
		createQuiz cq1 = new createQuiz(faculty, year, mcode, noQ, enrollKey, quizPass);
		
		//call validate method in createQuizDBUtil.java class
		createQuizDBUtil cqdb1 = new createQuizDBUtil();
		cqdb1.validate(cq1);
		
		
		//Redirect to insertQuestion.jsp page
		RequestDispatcher dis = request.getRequestDispatcher("insertQuestion.jsp");
		dis.forward(request, response);
	}


}
